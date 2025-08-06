import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int L, R, C;
  static int[] dx = {0, 0, -1, 1, 0, 0};
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dh = {0, 0, 0, 0, 1, -1};
  static int result;
  static char[][][] building;
  static int[][][] time;
  static Queue<Node> queue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 금 -> 이동x, 비어있음 -> 이동o
    // 6개의 칸으로 1분의 시간을 들여 이동
    // 탈출하는데 걸리는 시간

    StringBuilder sb = new StringBuilder();

    while (true) {
      result = 0;

      st = new StringTokenizer(br.readLine());
      L = Integer.parseInt(st.nextToken()); // 빌딩의 층 수
      R = Integer.parseInt(st.nextToken()); // 한 층의 행의 개수
      C = Integer.parseInt(st.nextToken()); // 한 층의 열의 개수

      if (L == 0 && R == 0 && C == 0) {
        break;
      }

      queue = new LinkedList<>();
      building = new char[L][R][C];
      time = new int[L][R][C];

      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          for (int k = 0; k < C; k++) {
            time[i][j][k] = -1;
          }
        }
      }

      Node start = new Node();
      Node end = new Node();

      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          String line = br.readLine();
          for (int k = 0; k < C; k++) {
            building[i][j][k] = line.charAt(k);
            if (building[i][j][k] == 'S') {
              start = new Node(i, j, k);
            } else if (building[i][j][k] == 'E') {
              end = new Node(i, j, k);
            }
          }
        }
        String blank = br.readLine();
      }

      Bfs(start, end);

      if (result == 0) {
        sb.append("Trapped!").append("\n");;
      } else {
        sb.append("Escaped in ").append(result).append(" minute(s).").append("\n");
      }
    }
    System.out.println(sb);
  }

  private static void Bfs(Node start, Node end) {
    queue.add(start);
    time[start.h][start.x][start.y] = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.h == end.h && node.x == end.x && node.y == end.y) {
        result = time[node.h][node.x][node.y];
        return;
      }
      for (int i = 0; i < 6; i++) {
        int nh = dh[i] + node.h;
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nh < L && nh >= 0 && nx < R && nx >= 0 && ny < C && ny >= 0) {
          if ((building[nh][nx][ny] == '.' || building[nh][nx][ny] == 'E') && time[nh][nx][ny] == -1) {
            queue.add(new Node(nh, nx, ny));
            time[nh][nx][ny] = time[node.h][node.x][node.y] + 1;
          }
        }
      }
    }

  }

  private static class Node {
    int h, x, y;

    public Node(int h, int x, int y) {
      this.h = h;
      this.x = x;
      this.y = y;
    }

    public Node() {}
  }
}