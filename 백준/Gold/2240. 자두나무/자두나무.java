import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken()); // 자두가 떨어지는 시간
    int W = Integer.parseInt(st.nextToken()); // 자두가 최대 움직일 수 있는 수
    
    long[] tree = new long[T+1]; // 1초부터 시작
    for (int i = 1; i <= T; i++) {
      tree[i] = Integer.parseInt(br.readLine());
    }

    // T 초까지 W 번 이동했을 때 자두를 받을 수 있는 최대 개수
    long[][] dp = new long[T+1][W+1];

    for (int t = 1; t <= T; t++) {
      for (int w = 0; w <= W; w++) {
        // 현재 이동 위치
        int current = (w % 2 == 0) ? 1 : 2; // 짝: 1번, 홀: 2번
        int isCatch = (tree[t] == current) ? 1: 0;

        if (w == 0) {
          // 이동하지 않았을 경우
          dp[t][w] = dp[t-1][w] + isCatch;
        } else {
          // 이동하지 않았을 경우, 이동한 경우 둘 중 최대
          dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1]) + isCatch;
        }
      }
    }

    // 최대값 찾기
    long answer = 0;
    for (int w = 0; w <= W; w++) {
      answer = Math.max(answer, dp[T][w]);
    }

    System.out.println(answer);
  }
}