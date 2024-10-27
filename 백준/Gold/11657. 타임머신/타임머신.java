import java.io.*;
import java.util.*;

public class Main {
    static Edge[] edges;
    static long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        edges = new Edge[M+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()); // 시작 도시
            int B = Integer.parseInt(st.nextToken()); // 도착 도시
            int C = Integer.parseInt(st.nextToken()); // 이동하는데 걸리는 시간

            edges[i] = new Edge(A, B, C);
        }

        // 벨만-포드 알고리즘 수행
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                // 더 작은 최단거리가 있으면 업데이트
                if (distance[e.start] != Integer.MAX_VALUE &&
                distance[e.end] > distance[e.start] + e.weight) {
                    distance[e.end] = distance[e.start] + e.weight;
                }
            }
        }

        // 음수 사이클 확인
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge e = edges[i];
            if (distance[e.start] != Integer.MAX_VALUE &&
            distance[e.end] > distance[e.start] + e.weight) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        } else {
            System.out.println(-1);
        }

        System.out.println(sb);
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}