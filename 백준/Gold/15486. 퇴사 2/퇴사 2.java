import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] day, pay;
  static int[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    day = new int[N+1];
    pay = new int[N+1];
    dp = new int[N+2]; // 10일에 1일치를 일하면 돈은 11일차에 받음

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      day[i] = Integer.parseInt(st.nextToken());
      pay[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = N; i >= 1; i--) {
      int nowDay = i + day[i]; // 뒤에서부터 최대 날짜 선택
      int select = 0;

      // 상담을 선택하는 경우
      if (nowDay <= N + 1) {
        select += pay[i] + dp[nowDay];
      }

      // 상담을 건너뛰는 경우
      int pass = dp[i+1];

      dp[i] = Math.max(select, pass);
    }

    System.out.println(dp[1]);
  }
}