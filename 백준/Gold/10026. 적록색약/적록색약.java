import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int N;
  static char[][] art;
  static boolean[][] visitedNo;
  static boolean[][] visitedYes;
  static int areaNo, areaYes;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    art = new char[N][N];
    visitedNo = new boolean[N][N];
    visitedYes = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        art[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visitedNo[i][j]) {
          areaNo++;
          BfsNo(i, j);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visitedYes[i][j]) {
          areaYes++;
          BfsYes(i, j);
        }
      }
    }

    System.out.println(areaNo + " " + areaYes);
  }

  private static void BfsNo(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y, art[x][y]));
    visitedNo[x][y] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < N && nx >= 0 && ny >= 0 && !visitedNo[nx][ny]) {
          if (node.color == art[nx][ny]) {
            queue.add(new Node(nx, ny, node.color));
            visitedNo[nx][ny] = true;
          }
        }
      }
    }
  }

  private static void BfsYes(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y, art[x][y]));
    visitedYes[x][y] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < N && nx >= 0 && ny >= 0 && !visitedYes[nx][ny]) {
          if (art[nx][ny] == 'R' || art[nx][ny] == 'G') {
            if (node.color == 'R' || node.color == 'G') {
              queue.add(new Node(nx, ny, node.color));
              visitedYes[nx][ny] = true;
            }
          } else {
            if (node.color == art[nx][ny]) {
              queue.add(new Node(nx, ny, node.color));
              visitedYes[nx][ny] = true;
            }
          }
        }
      }
    }
  }

  private static class Node {
    int x, y;
    char color;

    public Node(int x, int y, char color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }
  }
}