import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());

      // 1을 나타내는 방법: (1) 1가지
      // 2를 나타내는 방법: (1+1, 2) 2가지
      // 3을 나타내는 방법: (1+1+1, 1+2, 2+1, 3) 4가지
      // 4를 나타내는 방법: 7가지

      long[] dp = new long[n+1];

      dp[1] = 1;
      if (n >= 2) {
        dp[2] = 2;
      }
      if (n >= 3) {
        dp[3] = 4;
      }
      if (n >= 4) {
        for (int j = 4; j <= n; j++) {
          dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
          dp[j] %= 1000000009;
        }
      }

      sb.append(dp[n] %= 1000000009).append("\n");
    }

    System.out.println(sb);
  }
}