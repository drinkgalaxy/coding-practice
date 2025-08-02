import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int N;
  static char[][] house;
  static boolean[][] visited;
  static List<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    house = new char[N][N];
    visited = new boolean[N][N];

    int result = 0;

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        house[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (house[i][j] == '1' && !visited[i][j]) {
          Bfs(i, j);
          result++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(result).append("\n");

    Collections.sort(list);
    for (Integer i : list) {
      sb.append(i).append("\n");
    }

    System.out.println(sb);

  }

  private static void Bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    visited[x][y] = true;

    int count = 1;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < N && ny < N && nx >= 0 && ny >= 0) {
          if (house[nx][ny] == '1' && !visited[nx][ny]) {
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
            count++;
          }
        }
      }
    }

    list.add(count);
  }

  private static class Node {
    int x, y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}