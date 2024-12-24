import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    int num = 0;
    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (find(x) == find(y)) {
        num = i;
        break;
      } else {
        union(x, y);
      }
    }
    System.out.println(num);
  }

  public static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      if (a < b) {
        parent[b] = a;
      } else {
        parent[a] = b;
      }
    }
  }

  public static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}