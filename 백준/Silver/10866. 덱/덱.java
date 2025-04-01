import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> deque = new ArrayDeque<>();

    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      String[] order = br.readLine().split(" ");
      if (order[0].equals("push_front")) deque.addFirst(Integer.parseInt(order[1]));
      if (order[0].equals("push_back")) deque.addLast(Integer.parseInt(order[1]));
      if (order[0].equals("pop_front")) sb.append(!deque.isEmpty() ? deque.pollFirst() : -1).append("\n");
      if (order[0].equals("pop_back")) sb.append(!deque.isEmpty() ? deque.pollLast() : -1).append("\n");
      if (order[0].equals("size")) sb.append(deque.size()).append("\n");
      if (order[0].equals("empty")) sb.append(!deque.isEmpty() ? 0 : 1).append("\n");
      if (order[0].equals("front")) sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
      if (order[0].equals("back")) sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
    }

    System.out.println(sb);

  }
}
