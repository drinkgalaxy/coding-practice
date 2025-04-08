import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    // 정렬하고 합치기
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      queue.offer(Integer.parseInt(br.readLine())); // 10, 20, 40
    }

    int answer = 0;

    while (queue.size() > 1) {
      int a = queue.poll();
      int b = queue.poll();
      int temp = (a + b);
      answer += temp;
      queue.offer(temp);
    }

    System.out.println(answer);
  }
}