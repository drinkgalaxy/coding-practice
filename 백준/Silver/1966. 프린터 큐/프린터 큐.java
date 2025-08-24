import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 문서의 개수
      int M = Integer.parseInt(st.nextToken()); // 찾는 문서의 위치

      Queue<Document> queue = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int important = Integer.parseInt(st.nextToken()); // 중요도
        queue.add(new Document(j, important));
        pq.add(important);
      }

      int count = 1;
      while (!queue.isEmpty()) {
        Document poll = queue.poll();

        if (poll.important == pq.peek()) {
          pq.poll();
          if (poll.num == M) {
            sb.append(count).append("\n");
            break;
          }
          count++;
        } else {
          queue.add(new Document(poll.num, poll.important));
        }
      }
    }

    System.out.println(sb);
  }

  private static class Document {
    int num;
    int important;

    public Document(int num, int important) {
      this.num = num;
      this.important = important;
    }
  }
}