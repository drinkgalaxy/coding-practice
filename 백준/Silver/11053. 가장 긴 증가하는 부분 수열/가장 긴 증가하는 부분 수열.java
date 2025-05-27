import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static Integer[] dp;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    dp = new Integer[N];
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 부분 증가 수열 호출
    for (int i = 0; i < N; i++) {
      process(i);
    }

    // 최댓값 길이 찾기
    int max = dp[0];
    for (int i = 1; i < N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);

  }

  private static int process(int n) {
    if (dp[n] == null) {
      dp[n] = 1;
      for (int i = 0; i < n; i++) {
        if (arr[i] < arr[n]) {
          dp[n] = Math.max(dp[n], process(i) + 1);
        }
      }
    }
    return dp[n];
  }
}