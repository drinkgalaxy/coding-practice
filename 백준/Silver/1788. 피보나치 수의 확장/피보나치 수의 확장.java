import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int mn = Math.abs(n);

    long[] dp = new long[mn+1];

    dp[0] = 0;

    if (n == 0) {
      sb.append(0).append("\n").append(0);
    } else {
      dp[1] = 1;

      for (int i = 2; i <= mn; i++) {
        dp[i] = dp[i-1] + dp[i-2];
        dp[i] %= 1000000000;
      }

      if (n > 0) {
        sb.append(1).append("\n").append(Math.abs(dp[mn] % 1000000000));
      } else if (n < 0) {
        sb.append((n % 2 == 0) ? -1 : 1).append("\n").append(Math.abs(dp[mn] % 1000000000));
      }
    }

    System.out.println(sb);
  }
}