import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int tc = Integer.parseInt(br.readLine());

    for (int i = 0; i < tc; i++) {
      int n = Integer.parseInt(br.readLine()); // 팀의 수

      // 작년 순위 저장
      int[] arr = new int[n+1];
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 1; j <= n; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      // 그래프 초기화
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int j = 0; j <= n; j++) {
        graph.add(new ArrayList<>());
      }

      // 진입 차수 배열
      int[] indegree = new int[n+1];
      for (int j = 1; j <= n; j++) {
        for (int k = j+1; k <= n; k++) {
          graph.get(arr[j]).add(arr[k]);
          indegree[arr[k]]++;
        }
      }

      // 위처럼 더 늦게 오는 걸 진입 차수 배열에 ++

      // 바뀐 쌍 처리
      int m = Integer.parseInt(br.readLine());
      for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 간선 방향 변경
        if (graph.get(a).contains(b)) {
          graph.get(a).remove((Integer) b);
          graph.get(b).add(a);
          indegree[a]++;
          indegree[b]--;
        } else {
          graph.get(b).remove((Integer) a);
          graph.get(a).add(b);
          indegree[b]++;
          indegree[a]--;
        }
      }
      // 위상 정렬 수행
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 1; j <= n; j++) {
        if (indegree[j] == 0) {
          queue.offer(j);
        }
      }

      ArrayList<Integer> result = new ArrayList<>();
      boolean ambiguous = false;

      while (!queue.isEmpty()) {
        if (queue.size() > 1) {
          ambiguous = true;
          break;
        }

        int from = queue.poll();
        result.add(from);

        for (int j = 0; j < graph.get(from).size(); j++) {
          int to = graph.get(from).get(j);
          indegree[to]--;
          if (indegree[to] == 0) {
            queue.offer(to);
          }
        }
      }

      if (result.size() != n) {
        sb.append("IMPOSSIBLE").append("\n");
      } else if (ambiguous) {
        sb.append("?").append("\n");
      } else {
        for (Integer team : result) {
          sb.append(team).append(" ");
        }
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}
 