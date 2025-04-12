import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    List<Question> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int deadline = Integer.parseInt(st.nextToken());
      int ramen = Integer.parseInt(st.nextToken());
      list.add(new Question(deadline, ramen));
    }

    // 데드라인 오름차순 정렬
    Collections.sort(list);

    // 지금까지 선택된 문제들의 컵라면 수 저장
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (Question q : list) {
      int deadline = q.deadline;
      int ramen = q.ramen;

      pq.offer(ramen);

      // 지금까지 선택한 문제 수가 데드라인을 초과하면
      // 최소 컵라면 문제 제거
      if (pq.size() > deadline) {
        pq.poll();
      }
    }

    // 힙에 남은 모든 컵라면 수 더하기
    int result = 0;
    while (!pq.isEmpty()) {
      result += pq.poll();
    }
    System.out.println(result);
  }

  private static class Question implements Comparable<Question> {
    int deadline;
    int ramen;

    public Question(int deadline, int ramen) {
      this.deadline = deadline;
      this.ramen = ramen;
    }

    @Override
    public int compareTo(Question other) {
      return this.deadline - other.deadline;
    }
  }
}