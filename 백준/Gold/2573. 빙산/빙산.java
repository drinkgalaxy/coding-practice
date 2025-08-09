import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[][] ice;
  static boolean[][] visited;
  static int[][] melting;
  static int N, M, year, div;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 빙산이 두 덩어리 이상으로 분리되는 최초의 시간
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    ice = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        ice[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      visited = new boolean[N][M];
      melting = new int[N][M];
      div = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (!visited[i][j] && ice[i][j] != 0) {
            div++;
            Bfs(i, j);
          }
        }
      }

      if (div == 0) { // 다 녹아버렸을 경우
        year = 0;
        break;
      }

      if (div >= 2) { // 두 덩어리 이상으로 분리 됐을 경우
        break;
      }

      // 녹일 양 계산
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (ice[i][j] != 0) {
            melting[i][j] = nearWaterCheck(i, j);
          }
        }
      }

      // 녹아야 하는 걸 한번에 반영
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (ice[i][j] - melting[i][j] >= 0) {
            ice[i][j] -= melting[i][j];
          } else {
            ice[i][j] = 0;
          }
        }
      }

      year++;
    }

    System.out.println(year);
  }

  private static void Bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();

    queue.add(new Node(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      // 상하좌우 노드 확인
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < M && nx >= 0 && ny >= 0) {
          if (!visited[nx][ny] && ice[nx][ny] != 0) {
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  private static int nearWaterCheck(int x, int y) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      if (nx < N && ny < M && nx >= 0 && ny >= 0) {
        if (ice[nx][ny] == 0) {
          count++;
        }
      }
    }
    return count;
  }

  private static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }
}