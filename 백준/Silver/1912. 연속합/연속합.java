import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static Integer[] dp;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n+1];
    dp = new Integer[n+1];

    // 연속된 몇 개의 수를 선택

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    result = dp[1] = arr[1];

    for (int i = 1; i <= n; i++) {
      getResult(i);
    }

    System.out.println(result);
  }

  private static int getResult(int n) {
    if (dp[n] == null) {
      dp[n] = Math.max(getResult(n-1) + arr[n], arr[n]);
      result = Math.max(dp[n], result);
    }
    return dp[n];
  }
}