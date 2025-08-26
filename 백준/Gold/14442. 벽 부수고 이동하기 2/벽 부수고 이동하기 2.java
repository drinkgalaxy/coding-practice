import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M, K;
  static char[][] map;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    System.out.println(Bfs());

  }

  private static int Bfs() {

    int[][][] distance = new int[N][M][K + 1];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k <= K; k++) {
          distance[i][j][k] = -1;
        }
      }
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0, 0));
    distance[0][0][0] = 1;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.x == N-1 && node.y == M-1) {
        return distance[node.x][node.y][node.k];
      }

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < M && nx >= 0 && ny >= 0) {

          // 벽이 없을 때
          if (distance[nx][ny][node.k] == -1 && map[nx][ny] == '0') {
            queue.add(new Node(nx, ny, node.k));
            distance[nx][ny][node.k] = distance[node.x][node.y][node.k] + 1;
          }

          // 벽이 있을 때
          if (distance[nx][ny][node.k] == -1 && map[nx][ny] == '1') {
            if (node.k < K && distance[nx][ny][node.k + 1] == -1) { // 부술 벽이 남아있고, 이후를 탐색한 적이 없으면
              queue.add(new Node(nx, ny, node.k + 1));
              distance[nx][ny][node.k + 1] = distance[node.x][node.y][node.k] + 1;
            }
          }
        }
      }
    }
    return -1;
  }

  private static class Node {
    int x, y;
    int k;

    public Node(int x, int y, int k) {
      this.x = x;
      this.y = y;
      this.k = k;
    }
  }
}