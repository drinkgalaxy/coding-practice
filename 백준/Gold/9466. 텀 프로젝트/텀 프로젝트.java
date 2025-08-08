import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] students;
  static boolean[] visited;
  static boolean[] finished;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      students = new int[n+1];
      visited = new boolean[n+1];
      finished = new boolean[n+1];
      count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        students[j] = Integer.parseInt(st.nextToken());
      }

      for (int j = 1; j <= n; j++) {
        if (!visited[j]) {
          dfs(j);
        }
      }

      sb.append(n - count).append("\n");
    }
    System.out.println(sb);
  }

  static void dfs(int node) {
    visited[node] = true;
    int nextNode = students[node]; // 다음 탐색은 node 학생이 선택한 학생

    if (!visited[nextNode]) { // 한 번도 방문 안 했으면
      dfs(nextNode);
    } else if (!finished[nextNode]) { // 방문은 했는데 안 끝난 상태면
      while (nextNode != node) {
        count++;
        nextNode = students[nextNode]; // node 랑 일치할 때 까지 count++;
      }
      count++; // nextNode 포함
    }

    finished[node] = true;
  }
}
