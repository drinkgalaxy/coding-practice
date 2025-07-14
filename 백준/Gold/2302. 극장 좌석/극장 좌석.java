import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 좌석의 개수
    int M = Integer.parseInt(br.readLine()); // 고정석의 개수

    int[] fix = new int[M+1];
    for (int i = 1; i <= M; i++) {
      fix[i] = Integer.parseInt(br.readLine());
    }

    long[] dp = new long[N+1];
    dp[0] = 1; // 공집합일 경우의 수는 1
    dp[1] = 1;
    if (N >= 2) {
      dp[2] = 2;
    }
    for (int i = 3; i <= N; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    // 고정석을 기준으로 나눈 덩어리를 구해 정답 구함
    long answer = 1;
    for (int i = 1; i <= M; i++) {
      int free = fix[i] - fix[i-1] - 1; // 사이에 있는 자유석의 개수
      answer *= dp[free];
    }
    // 마지막 자유석의 개수
    answer *= dp[N - fix[M]];


    System.out.println(answer);
  }
}