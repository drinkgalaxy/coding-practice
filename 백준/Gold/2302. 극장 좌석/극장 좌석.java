import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입장권에 쓰여진 번호 대로 앉는데,
    // 본인의 바로 왼쪽 또는 오른쪽 좌석으로는 자리를 옮길 수 있음

    // VIP 회원들은 반드시 자기 번호 좌석에만 앉아야 함.

    // VIP 회원들의 좌석 번호들이 주어졌을 때, 사람들이 좌석에 앉는 서로 다른 방법의 가짓수는?

    // N = 1 일때 가짓수 1
    // N = 2 일때 가짓수 2
    // N = 3 일때 가짓수 3
    // N = 4 일때 가짓수 (1234, 2134, 1324, 1243, 2143) 5
    // 즉 점화식 = dp[i-1] + dp[i-2] 피보나치 수열의 점화식과 동일함

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
      int fixCount = fix[i] - fix[i-1] - 1; // 두 VIP 사이에 있는 자유 좌석의 개수
      answer *= dp[fixCount]; // 그 자유 좌석 안에서 가능한 자리 옮기기 수
      // 구간은 전부 독립실행이기 때문에 모든 구간의 수를 곱해야 함.
    }
    // 마지막 덩어리 처리
    answer *= dp[N - fix[M]];

    System.out.println(answer);
  }
}