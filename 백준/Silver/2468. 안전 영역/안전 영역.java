import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int N;
  static int[][] area;
  static int result;
  static Queue<Node> queue;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 물에 잠기지 않는 영역의 최대 개수 계산
    N = Integer.parseInt(br.readLine());
    area = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        area[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 0 부터 100까지 영역 테스트
    for (int i = 0; i <= 100; i++) {
      queue = new LinkedList<>();
      visited = new boolean[N][N];
      int count = 0;
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (area[j][k] > i && !visited[j][k]) {
            queue.add(new Node(j, k));
            visited[j][k] = true;
            count++;
            Bfs(i);
          }
        }
      }
      result = Math.max(count, result);
    }

    System.out.println(result);

  }

  private static void Bfs(int test) {

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < N && ny < N && nx >= 0 && ny >= 0 && !visited[nx][ny]) {
          if (area[nx][ny] > test) {
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
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