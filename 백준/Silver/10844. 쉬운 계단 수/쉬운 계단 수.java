import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] dp = new int[N+1][10];

    // 자리수 길이와 마지막 숫자를 기준으로 계단 수를 셈

    for (int i = 1; i <= 9; i++) { // 다만, 0으로 시작하는 수는 계단 수가 아님.
      dp[1][i] = 1; // 1자리 수 중 1~9는 계단 수
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) {
          dp[i][j] += dp[i-1][1];
        } else if (j == 9) {
          dp[i][j] += dp[i-1][8];
        } else {
          dp[i][j] += (dp[i-1][j-1] + dp[i-1][j+1]);
        }

        dp[i][j] %= 1000000000;
      }
    }

    // 길이가 N 인 계단 수의 합
    int result = 0;
    for (int i = 0; i <= 9; i++) {
      result = (result + dp[N][i]) % 1000000000;
    }

    System.out.println(result);
  }
}