import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int I;
  static boolean[][] visited;
  static Queue<Node> queue;
  static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  static int result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      I = Integer.parseInt(br.readLine());
      visited = new boolean[I][I];
      queue = new LinkedList<>();

      StringTokenizer st = new StringTokenizer(br.readLine());
      int sx = Integer.parseInt(st.nextToken());
      int sy = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int ex = Integer.parseInt(st.nextToken());
      int ey = Integer.parseInt(st.nextToken());

      Node start = new Node(sx, sy, 0);

      queue.add(start);
      visited[start.x][start.y] = true;
      Bfs(ex, ey);

      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

  private static void Bfs(int ex,  int ey) {

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.x == ex && node.y == ey) {
        result = node.count;
        return;
      }

      for (int i = 0; i < 8; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < I && ny < I && nx >= 0 && ny >= 0) {
          if (!visited[nx][ny]) {
            queue.add(new Node(nx, ny, node.count + 1));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  private static class Node {
    int x, y;
    int count;

    public Node(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}