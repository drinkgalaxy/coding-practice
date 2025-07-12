import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  static Integer[] dp;
  static int[] pre;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new int[N];
    dp = new Integer[N];
    pre = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      pre[i] = -1;
    }

    for (int i = 0; i < N; i++) {
      LIS(i);
    }

    int max = dp[0];
    int maxIndex = 0;
    for (int i = 0; i < dp.length; i++) {
      if (max < dp[i]) {
        max = dp[i];
        maxIndex = i;
      }
    }

    System.out.println(max);

    // 역추적
    Stack<Integer> stack = new Stack<>();
    while (maxIndex != -1) {
      stack.push(arr[maxIndex]);
      maxIndex = pre[maxIndex];
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    System.out.println(sb);

  }

  private static int LIS(int n) {
    if (dp[n] == null) {
      dp[n] = 1;
      for (int i = 0; i < n; i++) {
        if (arr[i] < arr[n]) {
          int lis = LIS(i) + 1;
          if (dp[n] < lis) {
            dp[n] = lis;
            pre[n] = i; // 이전 인덱스 저장
          }
        }
      }
    }
    return dp[n];
  }
}