import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Bfs(N, K);

  }

  private static void Bfs(int start, int end) {
    int[] distance = new int[100001];
    int[] pre = new int[100001];
    for (int i = 0; i < distance.length; i++) {
      distance[i] = -1;
      pre[i] = -1;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    distance[start] = 0;

    while (!queue.isEmpty()) {
      Integer poll = queue.poll();

      if (poll == end) {
        System.out.println(distance[poll]);
        printPath(pre, end); // 경로 복원
        return;
      }

      if (poll * 2 < 100001 && distance[poll * 2] == -1) {
        queue.add(poll * 2);
        distance[poll * 2] = distance[poll] + 1;
        pre[poll * 2] = poll; // 어디서 왔는지 기록
      }

      if (poll + 1 < 100001 && distance[poll + 1] == -1) {
        queue.add(poll + 1);
        distance[poll + 1] = distance[poll] + 1;
        pre[poll + 1] = poll;
      }

      if (poll - 1 >= 0 && distance[poll - 1] == -1) {
        queue.add(poll - 1);
        distance[poll - 1] = distance[poll] + 1;
        pre[poll - 1] = poll;
      }
    }
  }

  private static void printPath(int[] pre, int end) {
    Stack<Integer> stack = new Stack<>();
    int cur = end;
    while (cur != -1) {
      stack.push(cur);
      cur = pre[cur];
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    System.out.println(sb.toString());
  }
}