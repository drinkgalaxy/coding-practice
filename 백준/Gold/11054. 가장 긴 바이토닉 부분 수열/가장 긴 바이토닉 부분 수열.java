import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static Integer[] LIS_dp;
  static Integer[] LDS_dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    LIS_dp = new Integer[n];
    LDS_dp = new Integer[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 0부터 n-1까지 탐색 진행 - LIS
    for (int i = 0; i < n; i++) {
      LIS(i);
    }

    // 0부터 n-1까지 탐색 진행 - LDS
    for (int i = 0; i < n; i++) {
      LDS(i);
    }

    // 최댓값 찾기
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(LIS_dp[i] + LDS_dp[i], max);
    }

    // 값 출력
    System.out.println(max - 1);
  }

  private static int LIS(int n) {
    if (LIS_dp[n] == null) {
      LIS_dp[n] = 1;
      for (int i = 0; i < n; i++) { // n 이전!!
        if (arr[i] < arr[n]) {
          LIS_dp[n] = Math.max(LIS_dp[n], LIS(i) + 1);
        }
      }
    }
    return LIS_dp[n];
  }

  private static int LDS(int n) {
    if (LDS_dp[n] == null) {
      LDS_dp[n] = 1;
      for (int i = n+1; i < LDS_dp.length; i++) { // n 이후!!
        if (arr[i] < arr[n]) {
          LDS_dp[n] = Math.max(LDS_dp[n], LDS(i) + 1);
        }
      }
    }
    return LDS_dp[n];
  }
}