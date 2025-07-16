import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N 번째 순서에는 카드 N개가 포함된 카드팩이 놓여있음
    // 카드의 개수가 적은 팩이더라도 가격이 비싸면 구매
    //

    int N = Integer.parseInt(br.readLine());

    long[] cards = new long[N+1];
    long[] dp = new long[N+1];

    // 카드 1개를 갖기 위해 카드팩을 선택하면 남은 카드팩은 N-1
    // 카드 2개를 갖기 위해 카드팩을 선택하면 N-2
    // 그럼 카드 M개를 갖기 위해 카드팩을 선택하면 N-M

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j] + cards[j]);
      }
    }

    System.out.println(dp[N]);
  }
}