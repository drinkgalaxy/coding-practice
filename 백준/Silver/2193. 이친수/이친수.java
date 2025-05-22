import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[N+1][2];

    // 한 자리수 일 때 0으로 끝나는거 0개, 1로 끝나는거 1개
    dp[1][0] = 0;
    dp[1][1] = 1;
    // 두 자리수 일 때 0으로 끝나는거 1개, 1로 끝나는거 0개

    // 0 뒤엔 0과 1이 올 수 있다.
    // 1 뒤엔 0만 올 수 있다.

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-1][1];
      dp[i][1] = dp[i-1][0];
    }

    System.out.println(dp[N][0] + dp[N][1]);
  }
}