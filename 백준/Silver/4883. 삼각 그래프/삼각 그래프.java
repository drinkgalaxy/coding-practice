import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int testCase = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 가장 위쪽 가운데 정점에서 출발
    // 가장 아래쪽 가운데 정점으로 가는 최단 경로
    // 어떤 경로의 비용은 그 경로에서 지나간 정점의 비용의 합

    StringBuilder sb = new StringBuilder();

    while (true) {
      int N = Integer.parseInt(br.readLine());

      if (N == 0) {
        break;
      }

      testCase++;

      int[][] graph = new int[N][3];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[N][3];

      for (int i = 0; i < N; i++) {
        dp[i][0] = Integer.MAX_VALUE;
        dp[i][1] = Integer.MAX_VALUE;
        dp[i][2] = Integer.MAX_VALUE;
      }

      // 0행 (시작점)
      // dp[0][0]은 도달 불가능
      dp[0][1] = graph[0][1];
      dp[0][2] = dp[0][1] + graph[0][2];

      // 1행
      dp[1][0] = dp[0][1] + graph[1][0];
      dp[1][1] = Math.min(dp[1][0], Math.min(dp[0][1], dp[0][2])) + graph[1][1]; // 왼쪽은 아예 도달 불가능
      dp[1][2] = Math.min(dp[1][1], Math.min(dp[0][1], dp[0][2])) + graph[1][2];

      for (int i = 2; i < N; i++) {
        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][0];
        dp[i][1] = Math.min(dp[i-1][1], Math.min(dp[i-1][0], Math.min(dp[i-1][2], dp[i][0]))) + graph[i][1];
        dp[i][2] = Math.min(dp[i-1][2], Math.min(dp[i-1][1], dp[i][1])) + graph[i][2];
      }

      sb.append(testCase).append(". ").append(dp[N-1][1]).append("\n");
    }

    System.out.println(sb);
  }
}