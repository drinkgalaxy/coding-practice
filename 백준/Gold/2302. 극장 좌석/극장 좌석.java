import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] fix = new int[M+1];
    for (int i = 1; i <= M; i++) {
      fix[i] = Integer.parseInt(br.readLine());
    }

    // N = 1 일 때, 1가지
    // N = 2 일 때, 2가지
    // N = 3 일 때, (123, 132, 213) 3가지
    // N = 4 일 때, (1234, 2134, 1243, 2143, 1324) 5가지
    // 따라서 점화식 dp[i] = dp[i-1] + dp[i-2]

    long[] dp = new long[N+1];
    dp[0] = 1; // 공집합은 1
    dp[1] = 1;
    if (N >= 2) {
      dp[2] = dp[1] + dp[0];
    }
    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    // 덩어리 구하기
    long answer = 1;
    for (int i = 1; i <= M; i++) {
      int seats = fix[i] - fix[i-1] - 1;
      answer *= dp[seats];
    }
    // 마지막 덩어리 구하기
    answer *= dp[N - fix[M]];

    System.out.println(answer);
  }
}