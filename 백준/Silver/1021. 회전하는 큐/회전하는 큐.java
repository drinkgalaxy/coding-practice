import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static LinkedList<Integer> deque = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 큐의 원소 개수
    int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수


    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }

    int[] arr = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int n = Integer.parseInt(st.nextToken());
      arr[i] = deque.get(n - 1);
    }

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      while (true) {

        if (deque.peekFirst() == arr[i]) {
          deque.pollFirst();
          break;
        }

        if (check(arr[i])) {
          deque.addLast(deque.pollFirst());
          count++;
        } else {
          deque.addFirst(deque.pollLast());
          count++;
        }
      }
    }

    System.out.println(count);
  }

  private static boolean check(int n) {
    for (int i = 1; i <= deque.size()/ 2; i++) {
      if (deque.get(i) == n) {
        return true;
      }
    }
    return false; // true면 왼쪽이 더 빠름, false면 오른쪽이 더 빠름
  }
}