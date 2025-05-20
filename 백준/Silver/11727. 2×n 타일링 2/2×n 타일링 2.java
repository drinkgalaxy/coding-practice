import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];

    // 1 일 때 1가지 방법
    dp[1] = 1;
    // 2 일 때 3가지 방법
    if (n >= 2) dp[2] = 3;
    // 3 일 때 5가지 방법
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007; // 보드의 마지막을 채우는 방법이 2배임
    }

    System.out.println(dp[n]);
  }
}