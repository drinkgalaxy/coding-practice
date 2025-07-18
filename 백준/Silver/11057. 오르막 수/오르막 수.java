import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    
    // 길이가 1인 오르막의 수
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 즉, 자기자신
    // 길이가 2인 오르막의 수
    // 01, 02, 03, 04, 05, 06, 07, 08, 09
    // 12, 13, 14, 15, ...
    // 23, 24, 25, 26, ...
    // 34, 35, 36, ...
    // 45, 46, 47, ...
    
    long[][] dp = new long[N+1][10];

    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i-1][k];
        }
        dp[i][j] %= 10007;
      }
    }

    long answer = 0;
    for (int i = 0; i < 10; i++) {
      answer += dp[N][i];
    }

    System.out.println(answer % 10007);
  }
}