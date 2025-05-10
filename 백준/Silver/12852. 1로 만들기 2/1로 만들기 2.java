import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N+1];
    int[] from = new int[N+1];

    dp[0] = 0;
    dp[1] = 0; // 1이면 정답이니까 더 이상 연산할 필요 x, 따라서 연산 횟수는 0

    for (int i = 2; i <= N; i++) {
      // 기본값: i-1 일 때
      dp[i] = dp[i-1] + 1;
      from[i] = i-1;

      // i가 2로 나누어 떨어질 때의 값이 더 작을 경우 갱신
      if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
        dp[i] = dp[i/2] + 1;
        from[i] = i/2;
      }

      // i가 3으로 나누어 떨어질 때의 값이 더 작을 경우 갱신
      if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
        dp[i] = dp[i/3] + 1;
        from[i] = i/3;
      }
    }

    StringBuilder sb = new StringBuilder(); // 역추적
    int current = N; // N 부터 from[current]를 따라가면서 경로를 복원

    while (current > 0) {
      sb.append(current).append(" ");
      current = from[current];
    }
    System.out.println(dp[N]);
    System.out.println(sb);
  }
}