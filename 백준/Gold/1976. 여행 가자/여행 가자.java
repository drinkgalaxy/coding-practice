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
import org.w3c.dom.Node;


public class Main {
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    parent = new int[N+1];

    // 초기화
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }

    for (int x = 1; x <= N; x++) {
      st = new StringTokenizer(br.readLine());
      for (int y = 1; y <= N; y++) {
        int i = Integer.parseInt(st.nextToken());
        if (i == 1) {
          union(x, y);
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    int root = find(Integer.parseInt(st.nextToken()));
    boolean check = true;
    for (int x = 1; x < M; x++) {
      int i = Integer.parseInt(st.nextToken());
      if (root != find(i)) {
        check = false;
        break;
      }
    }

    if (check) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }

  static void union(int a, int b) {
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

  static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}
 