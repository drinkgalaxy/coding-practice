import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 각각의 카드에는 등급을 나타내는 색, 8가지
    // 카드팩의 종류는 카드 1개부터 ~ 카드 N 개까지 다양함.
    // 돈을 최대한 많이 써서 카드 N개 구매할거임.
    // 카드가 i개 포함된 카드팩의 가격은 Pi원
    // 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값

    // 카드가 1개 들어있는 카드팩을 구매하고 카드 i-1개를 구입한다.
    // 카드가 2개 들어있는 카드팩을 구매하고 카드 i-2개를 구입한다.
    // 점화식: dp[i] = dp[i-j] + cards[j];

    int N = Integer.parseInt(br.readLine());
    long[] cards = new long[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    long[] dp = new long[N+1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j] + cards[j]);
      }
    }

    System.out.println(dp[N]);
  }
}