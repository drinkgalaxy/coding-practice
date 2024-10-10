import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 마을 개수
        int E = Integer.parseInt(st.nextToken()); // 도로 개수

        int[][] distance = new int[V+1][V+1];
        final int INF = 987654321;

        // 인접 행렬 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (distance[a][b] > c) {
                distance[a][b] = c;
            }
        }

        // 플로이드 워셜 알고리즘 수행
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // 최소 사이클 길이 찾기 (자기 자신으로 돌아오는 경로 중 가장 짧은 것)
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue; // 자기 자신을 제외한 두 정점이
                } // 서로에게 가는 경로가 있다면, 사이클 존재
                if (distance[i][j] != INF && distance[j][i] != INF) {
                    // 최소 사이클의 도로 길이의 합을 구하기
                    minCycle = Math.min(minCycle, distance[i][j] + distance[j][i]);
                }
            }
        }

        if (minCycle == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minCycle);
        }
    }
}