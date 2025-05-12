import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int[][] arr;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 삼각형의 크기
    arr = new int[n][n];
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      dp[n-1][i] = arr[n-1][i]; // 맨 아래 dp 초기값
    }

    // 아래에서부터 위로 올라가면서 누적 최대값 계산
    for (int i = n-2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
      }
    }

    System.out.println(dp[0][0]); // 최종 결과는 꼭대기
  }
}