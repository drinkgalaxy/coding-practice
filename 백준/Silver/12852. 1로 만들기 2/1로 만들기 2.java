import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N+1];
    int[] from = new int[N+1];

    dp[1] = 0;

    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      from[i] = i - 1;

      if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
        dp[i] = dp[i / 2] + 1;
        from[i] = i / 2;
      }

      if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
        dp[i] = dp[i / 3] + 1;
        from[i] = i / 3;
      }
    }

    StringBuilder sb = new StringBuilder();
    int current = N;
    while (current > 0) {
      sb.append(current).append(" ");
      current = from[current];
    }

    System.out.println(dp[N]);
    System.out.println(sb);
  }
}