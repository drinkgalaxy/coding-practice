import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[N+1][2]; // 끝자리가 0 또는 1

    // 1 자리 이친수 : 1
    dp[1][1] = 1;
    dp[1][0] = 0;
    // 2 자리 이친수 : 10
    // 3 자리 이친수 : 100, 101
    // 4 자리 이친수 : 1000, 1001, 1010
    // 5 자리 이친수 : 10000, 10001, 10100, 10101

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i-1][1] + dp[i-1][0]; // 0은 1, 0 뒤에 모두 붙일 수 있음
      dp[i][1] = dp[i-1][0]; // 1은 0 뒤에만 붙일 수 있음
    }
    System.out.println(dp[N][0] + dp[N][1]);

  }
}