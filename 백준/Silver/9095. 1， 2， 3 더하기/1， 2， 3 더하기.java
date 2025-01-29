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

    for (int t = 0; t < T; t++) {
      int num = Integer.parseInt(br.readLine());
      int[] dp = new int[11];
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;

      for (int i = 4; i <= num; i++) {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
      }

      sb.append(dp[num]).append("\n");
    }

    System.out.println(sb);
  }
}
 