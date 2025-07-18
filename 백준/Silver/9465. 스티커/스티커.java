import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());

      int[][] stickers = new int[2][n+1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        stickers[0][j] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        stickers[1][j] = Integer.parseInt(st.nextToken());
      }

      int[][] dp = new int[2][n+1];

      dp[0][1] = stickers[0][1];
      dp[1][1] = stickers[1][1];

      for (int j = 2; j <= n; j++) {
        dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
        dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
      }

      sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
    }
    System.out.println(sb);
  }
}