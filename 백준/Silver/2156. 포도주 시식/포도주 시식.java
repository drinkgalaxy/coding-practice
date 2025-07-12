import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n+1];
    int[] dp = new int[n+1];

    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0];
    dp[1] = arr[1]; // 첫 번째
    if (n >= 2) { // 첫 번째와 두 번째 연속으로
      dp[2] = arr[1] + arr[2];
    }

    // 경우 1) i번째 잔을 마시지 않을 경우 dp[i-1]가 최선
    // 경우 2) i번째 잔만 마시는 경우 (i-1 안마심) dp[i-2] + arr[i]가 최선
    // 경우 3) i-1, i 잔을 연속으로 마시는 경우 (i-2 안마심) dp[i-3] + arr[i-1] + arr[i]

    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i],
          dp[i-3] + arr[i-1] + arr[i]));
    }

    System.out.println(dp[n]);
  }
}