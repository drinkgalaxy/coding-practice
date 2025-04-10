import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      PriorityQueue<Long> queue = new PriorityQueue<>();

      int K = Integer.parseInt(br.readLine()); // 소설을 구성하는 장의 수
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < K; j++) {
        queue.offer(Long.parseLong(st.nextToken()));
      }
      long sum = 0;
      while (queue.size() > 1) {
        long file1 = queue.poll();
        long file2 = 0;
        if (!queue.isEmpty()) {
          file2 = queue.poll();
        }
        long temp = file1 + file2;
        sum += temp;
        queue.offer(temp);
      }
      sb.append(sum).append("\n");
    }

    System.out.println(sb);
  }
}