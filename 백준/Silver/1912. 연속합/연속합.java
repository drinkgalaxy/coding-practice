import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static Integer[] dp;
  static int value;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    arr = new int[n+1];
    dp = new Integer[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

   // 첫 원소 초기화
    dp[0] = arr[0];
    value = dp[1] = arr[1];

    getMax(n);

    System.out.println(value);

  }

  private static int getMax(int n) {
    if (dp[n] == null) {
      // 이전 배열의 누적합 + 현재 값과 현재 값을 비교하여 최댓값 저장
      dp[n] = Math.max(getMax(n-1) + arr[n], arr[n]);
      value = Math.max(dp[n], value);
    }
    return dp[n];
  }
}