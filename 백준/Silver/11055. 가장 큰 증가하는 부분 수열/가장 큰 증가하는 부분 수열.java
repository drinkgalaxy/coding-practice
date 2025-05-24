import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static Integer[] dp;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    dp = new Integer[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 0부터 n-1까지 탐색 진행
    for (int i = 0; i < n; i++) {
      LIS(i);
    }

    // 최댓값 찾기
    int max = dp[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, dp[i]);
    }

    // 값 출력
    System.out.println(max);
  }

  private static int LIS(int n) {
    if (dp[n] == null) {
      dp[n] = arr[n]; // 길이가 아니라 합으로 초기화
      for (int i = 0; i < n; i++) {
        if (arr[i] < arr[n]) {
          // 즉, arr[n] 이 더 크면 증가시킴
          dp[n] = Math.max(dp[n], LIS(i) + arr[n]);
        }
      }
    }
    return dp[n];
  }
}