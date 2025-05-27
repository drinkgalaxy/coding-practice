import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
  static long[] dp = new long[101];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    dp[3] = dp[2] = dp[1] = 1;
    dp[4] = 2;

    for (int i = 5; i <= 100; i++) {
      // 삼각형을 이어붙이는 규칙 = 두 삼각형 전의 변의 길이 + 세 삼각형 전의 변의 길이
      dp[i] = dp[i-1] + dp[i-5];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }
    System.out.println(sb);
  }
}