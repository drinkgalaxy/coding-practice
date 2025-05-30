import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    int[][] dp = new int[41][2];

    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-2][0]; // 0 호출 횟수
      dp[i][1] = dp[i-1][1] + dp[i-2][1]; // 1 호출 횟수
    }

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
    }

    System.out.println(sb);
  }
}
 