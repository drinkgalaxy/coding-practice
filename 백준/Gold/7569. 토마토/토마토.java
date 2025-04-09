import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dh = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, -1, 1, 0, 0};
  static int[] dy = {0, 0, 0, 0, 1, -1};
  static int[][][] box;
  static Queue<Node> queue = new LinkedList<>();
  static int H, N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    box = new int[H][N][M];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          box[i][j][k] = Integer.parseInt(st.nextToken());
          if (box[i][j][k] == 1) {
            queue.offer(new Node(i, j, k, 0));
          }
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
      for (int i = 0; i < 6; i++) {
        int nh = now.h + dh[i];
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];
        if (nh < H && nx < N && ny < M && nh >= 0 && nx >= 0 && ny >= 0) {
          if (box[nh][nx][ny] == 0) {
            box[nh][nx][ny] = 1;
            queue.offer(new Node(nh, nx, ny, date + 1));
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
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (box[i][j][k] == 0) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static class Node {
    int h;
    int x;
    int y;
    int date;

    public Node(int h, int x, int y, int date) {
      this.h = h;
      this.x = x;
      this.y = y;
      this.date = date;
    }
  }
}