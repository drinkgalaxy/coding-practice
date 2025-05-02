import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[] arr;
  static Integer[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 계단의 개수

    arr = new int[N + 1];
    dp = new Integer[N+1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0]; // index 0 은 시작점
    dp[1] = arr[1];
    if (N >= 2) {
      dp[2] = arr[1] + arr[2];
    }

    System.out.println(getMax(N));
  }

  private static int getMax(int n) {
    if (dp[n] == null) {
      dp[n] = Math.max(getMax(n-3) + arr[n-1], getMax(n-2)) + arr[n];
      // dp[4] = Math.max(getMax(1) + arr[3], getMax(2)) + arr[4];
    }
    return dp[n];
  }
}
