import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int[][] distance; // 인접 행렬 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        distance = new int[n+1][n+1];

        // 인접 행렬 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) { // 시작 도시와 출발 도시가 같으면 비용이 0
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 버스의 시작 도시
            int b = Integer.parseInt(st.nextToken()); // 버스의 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 한번 타는데 필요한 비용

            if (distance[a][b] > c) { // 주어진 버스 비용 정보를 인접 행렬에 저장
                distance[a][b] = c;
            }
        }

        // 플로이드 워셜 알고리즘 수행 (k가 가장 바깥쪽이 되야함.)
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // 정답 배열 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == 10000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j]+ " ");
                }
            }
            System.out.println();
        }
    }
}