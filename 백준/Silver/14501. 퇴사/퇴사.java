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

    // 뒤에서부터 DP 계산
    for (int i = N; i >= 1; i--) {
      // 상담을 선택할 때 얻는 이익
      int finishDay = i + T[i]; // 마지막 날 이익
      int pay = 0;
      if (finishDay <= N + 1) {
        pay = P[i] + dp[finishDay];
      }

      // i 일부터 상담을 건너뒬 때 얻는 이익
      int skip = dp[i + 1];

      dp[i] = Math.max(pay, skip);
    }

    System.out.println(dp[1]);
  }
}