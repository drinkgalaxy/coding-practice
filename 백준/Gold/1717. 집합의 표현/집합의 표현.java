import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken()); // 집합의 개수
    int m = Integer.parseInt(st.nextToken()); // 연산의 개수

    parent = new int[n+1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (x == 1) {
        if (find(a) == find(b)) {
          sb.append("YES").append("\n");
        } else {
          sb.append("NO").append("\n");
        }
      } else {
        union(a, b);
      }
    }

    System.out.println(sb);
  }

  private static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }

  private static void union(int a, int b) {
    int pa = find(a);
    int pb = find(b);
    
    if (pa != pb) {
      if (pa < pb) {
        parent[pb] = pa;
      } else {
        parent[pa] = pb;
      }
    }
  }
}
