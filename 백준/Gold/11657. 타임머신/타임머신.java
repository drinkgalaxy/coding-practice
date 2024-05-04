import java.io.*;
import java.util.*;

// 에지 리스트를 다루기 위해 클래스 별도 구현
class Edge {
    int start, end, time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class Main {
    static int N, M;
    static Edge edges[];
    static long distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M+1];
        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 거리배열 초기화
        for (int i = 0; i < M; i++) { // 에지 리스트에 데이터 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        // 벨만-포드 알고리즘 수행
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        // 음수 사이클의 유무 확인
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true; // 값 업데이트 대신 mCycle을 true로 변경
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
        } else {
            System.out.println(-1);
        }
    }
}
