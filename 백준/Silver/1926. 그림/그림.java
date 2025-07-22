import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int total, area;
  static int[][] draw;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int n, m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1로 연결된 것이 한 그림
    // 그림의 넓이란 그림에 포함된 1의 개수

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    draw = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        draw[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (draw[i][j] == 1 && !visited[i][j]) {
          total++;
          BFS(i, j);
        }
      }
    }

    System.out.println(total);
    System.out.println(area);

  }

  public static void BFS(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    visited[x][y] = true;

    int count = 1;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (draw[nx][ny] == 1 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            count++;
            queue.add(new Node(nx, ny));
          }
        }
      }
    }

    area = Math.max(area, count);
  }

  public static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


}