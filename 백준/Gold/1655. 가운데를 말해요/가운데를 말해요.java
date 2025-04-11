import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (maxHeap.size() == minHeap.size()) {
        maxHeap.add(num);
      } else {
        minHeap.add(num);
      }

      // maxHeap 이 더 클 경우 원소 switch
      if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
        if (maxHeap.peek() > minHeap.peek()) {
          int tmp = maxHeap.poll();
          maxHeap.offer(minHeap.poll());
          minHeap.offer(tmp);
        }
      }
      sb.append(maxHeap.peek()).append("\n");
    }
    System.out.println(sb);
  }
}