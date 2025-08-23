import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.DoubleBuffer;
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
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      Queue<Document> queue = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int important = Integer.parseInt(st.nextToken());
        queue.add(new Document(j, important)); // 문서번호, 중요도
        pq.add(important); // 중요도만 따로 관리
      }

      int index = 0;
      while (!queue.isEmpty()) {
        Document poll = queue.poll();

        if (poll.important == pq.peek()) { // 현재 문서가 가장 높은 중요도를 가졌다면 출력
          pq.poll();
          index++;
          if (poll.sequence == M) { // 찾는 순서라면
              sb.append(index).append("\n");
            break;
          }
        } else { // 재배치
          queue.add(poll);
        }
      }
    }
    System.out.println(sb);
  }

  private static class Document {
    int sequence;
    int important;

    public Document(int sequence, int important) {
      this.sequence = sequence;
      this.important = important;
    }
  }
}