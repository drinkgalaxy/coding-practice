import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;


public class Main {

  static int N, M;
  static char[][] miro;
  static int[][] distance;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    miro = new char[N][M];
    distance = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        miro[i][j] = line.charAt(j);
        distance[i][j] = -1;
      }
    }

    distance[0][0] = 1;
    bfs(0, 0);

    System.out.println(distance[N-1][M-1]);
  }

  private static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];
        if (nx < N && nx >= 0 && ny < M && ny >= 0) {
          if (miro[nx][ny] == '1' && distance[nx][ny] == -1) {
            queue.offer(new Node(nx, ny));
            distance[nx][ny] = distance[now.x][now.y] + 1;
          }
        }
      }
    }
  }

  private static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
 
