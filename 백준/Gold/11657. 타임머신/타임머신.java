import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static Edge[] edge;
    static long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        edge = new Edge[M+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edge[i] = new Edge(A, B, C);
        }

        // 벨만-포드 알고리즘 수행
        distance[1] = 0; // 출발지점
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = edge[j];
                // 더 작은 최단거리가 있으면 업데이트
                if (distance[e.start] != Integer.MAX_VALUE &&
                    distance[e.end] > distance[e.start] + e.weight) {
                    distance[e.end] = distance[e.start] + e.weight;
                }
            }
        }
        // 음수 사이클 확인하기
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge e = edge[i];
            if (distance[e.start] != Integer.MAX_VALUE &&
                    distance[e.end] > distance[e.start] + e.weight) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else { // 음의 사이클이 있을 때
            System.out.println(-1);
        }
    }
    public static class Edge {
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