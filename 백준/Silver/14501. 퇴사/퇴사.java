import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] T = new int[N+1];
    int[] P = new int[N+1];
    int[] dp = new int[N+2]; // 10일에 1일치를 일하면 돈은 11일에 받음

    // 1. 일단 날짜와 수익 각각 저장
    // 2. 날짜를 N이 넘지 않도록 선택해보면서 최대 값 구하기

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = N; i >= 1; i--) {
      // 그 날을 선택함
      int select = i + T[i];
      int pay = 0; // select 와 pay 각각 초기화
      if (select <= N + 1) {
        pay = P[i] + dp[select];
      }

      // 그 날을 선택하지 않음
      int pass = dp[i+1];

      dp[i] = Math.max(pay, pass); // 결론은 둘 중에 더 큰거
    }

    System.out.println(dp[1]);

  }
}