import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, island;
  static int result = Integer.MAX_VALUE;
  static int[][] map;
  static int[][] distance;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 대륙이 한 번이라도 이어졌으면 끝, 이때의 가장 짧은 다리를 놓아 연결하는 방법

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    island = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          island++;
          labelingBfs(i, j, island);
        }
      }
    }

    for (int i = 1; i <= island; i++) {
      findingBridgeBfs(i);
    }

    System.out.println(result);
  }

  private static void labelingBfs(int x, int y, int islandNum) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    visited[x][y] = true;
    map[x][y] = islandNum;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < N && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
          if (map[nx][ny] == 1) {
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
            map[nx][ny] = islandNum;
          }
        }
      }
    }
  }

  private static void findingBridgeBfs(int islandNum) {
    Queue<Node> queue = new LinkedList<>();
    distance = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        distance[i][j] = -1;
        if (map[i][j] == islandNum) { // 현재 탐색중인 섬이라면
          queue.add(new Node(i, j));
          distance[i][j] = 0; // 전부 큐에 넣기 - 여러 시작점에서 동시에 퍼져나가야 하기 때문
        }
      }
    }

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < N && ny < N && nx >= 0 && ny >= 0 && distance[nx][ny] == -1) {

          if (map[nx][ny] > 0 && map[nx][ny] != islandNum) { // 현재 탐색중인 섬과 다른 곳을 찾았을 경우
            result = Math.min(result, distance[node.x][node.y]); // 최단 거리 갱신
            return;
          }

          if (map[nx][ny] == 0) {
            queue.add(new Node(nx, ny));
            distance[nx][ny] = distance[node.x][node.y] + 1;
          }
        }

      }
    }
  }

  private static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}