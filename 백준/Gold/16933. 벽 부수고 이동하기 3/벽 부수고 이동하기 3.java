import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    Queue<Node> queue = new ArrayDeque<>();

    int[][][][] distance = new int[N][M][K+1][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k <= K; k++) {
          distance[i][j][k][0] = -1; // 낮
          distance[i][j][k][1] = -1; // 밤
        }
      }
    }

    queue.add(new Node(0, 0, 0, 0));
    distance[0][0][0][0] = 1;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int dist = distance[node.x][node.y][node.k][node.time];

      if (node.x == N-1 && node.y == M-1) {
        return distance[node.x][node.y][node.k][node.time];
      }

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];

        if (nx < N && ny < M && nx >= 0 && ny >= 0) {

          // 벽이 아닐 때
          if (distance[nx][ny][node.k][node.time^1] == -1 && map[nx][ny] == '0') {
            queue.add(new Node(nx, ny, node.k, node.time^1));
            distance[nx][ny][node.k][node.time^1] = dist + 1;
          }

          // 낮이고 k < K 인 경우엔 벽을 부수고 이동할 수 있음
          if (node.time == 0 && node.k + 1 <= K) {
            if (distance[nx][ny][node.k + 1][node.time^1] == -1 && map[nx][ny] == '1') {
              queue.add(new Node(nx, ny, node.k + 1, node.time^1));
              distance[nx][ny][node.k + 1][node.time^1] = dist + 1;
            }
          }
        }
      }

      // 밤일 때 제자리에 머무르는 선택 허용 -> for 문 밖에서 실행해야 함
      if (node.time == 1) {
        if (distance[node.x][node.y][node.k][node.time^1] == -1) {
          queue.add(new Node(node.x, node.y, node.k, node.time^1));
          distance[node.x][node.y][node.k][node.time^1] = dist + 1;
        }
      }
    }

    return -1;

  }

  private static class Node {
    int x, y;
    int k;
    int time; // 0 일 때 낮, 1 일 때 밤

    public Node(int x, int y, int k, int time) {
      this.x = x;
      this.y = y;
      this.k = k;
      this.time = time;
    }
  }
}