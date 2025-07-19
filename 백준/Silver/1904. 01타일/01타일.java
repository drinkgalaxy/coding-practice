import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    // 지원이가 만들 수 있는, 길이가 N인 모든 2진 수열의 개수
    // 1또는 00 사용가능

    // 길이가 1일 때 2진 수열의 개수 = (1) 1개
    // 길이가 2일 때 2진 수열의 개수 = (00, 11) 2개
    // 길이가 3일 때 2진 수열의 개수 = (001, 100, 111) 3개
    // 길이가 4일 때 2진 수열의 개수 = (0011, 0000, 1001, 1100, 1111) 5개

    long[] dp = new long[N+1];

    dp[0] = 1;
    dp[1] = 1;
    if (N >= 2) {
      dp[2] = dp[0] + dp[1];
    }

    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i-1] + dp[i-2];
      dp[i] %= 15746;
    }

    System.out.println(dp[N] % 15746);
  }
}