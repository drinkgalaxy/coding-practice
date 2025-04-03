import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String p = br.readLine(); // 함수
      int n = Integer.parseInt(br.readLine()); // 배열의 수의 개수
      LinkedList<Integer> deque = new LinkedList<>();
      boolean isReversed = false;
      boolean isError = false;

      String input = br.readLine(); // 명령
      input = input.replace("[", "").replace("]", "");

      if (!input.isEmpty()) {
        String[] arr = input.split(",");
        for (String s : arr) {
          deque.add(Integer.parseInt(s));
        }
      }

      for (String pp : p.split("")) {
        if (pp.equals("R")) {
          // deque 에 있는 숫자들 뒤집기
          isReversed = !isReversed;
        } else {
          if (deque.isEmpty()) {
            isError = true;
            break;
          }
          if (isReversed) {
            deque.pollLast();
          } else {
            deque.pollFirst();
          }
        }
      }

      if (isError) {
        sb.append("error");
      } else {
        sb.append("[");
        while (!deque.isEmpty()) {
          sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
          if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}