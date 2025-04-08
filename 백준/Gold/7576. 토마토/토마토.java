import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {-1, 1, 0, 0}; // 왼쪽, 오른쪽, 앞, 뒤
  static int[] dy = {0, 0, 1, -1};
  static int M, N;
  static int[][] box;
  static Queue<Node> queue = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken()); // col
    N = Integer.parseInt(st.nextToken()); // row

    box = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if (box[i][j] == 1) {
          queue.offer(new Node(i, j, 0));
        }
      }
    }

    bfs();
  }

  private static void bfs() {
    int date = 0;
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      date = now.date;
      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];
        if (nx < N && ny < M && nx >= 0 && ny >= 0) {
          if (box[nx][ny] == 0) {
            box[nx][ny] = 1;
            queue.offer(new Node(nx, ny, date + 1));
          }
        }
      }
    }

    if (check()) {
      System.out.println(date);
    } else {
      System.out.println(-1);
    }
  }

  private static boolean check() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private static class Node {
    int x;
    int y;
    int date;

    public Node(int x, int y, int date) {
      this.x = x;
      this.y = y;
      this.date = date;
    }
  }
}