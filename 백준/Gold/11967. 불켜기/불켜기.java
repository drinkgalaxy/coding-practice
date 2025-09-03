import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static ArrayList<Node>[][] room;
  static boolean[][] light;
  static boolean[][] visited;
  static int N;
  static int result = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // (x, y) 방에서 (a, b) 방의 불을 켜고 끌 수 있다.
    // 불을 켠다 -> 방의 상태가 켜진 상태
    // 불을 끈다 -> 방의 상태가 꺼진 상태
    // 그럼 방의 상태는 방문하기 전 false, 방문해서 불 켰을 때 true
    // 상하좌우 인접한 방의 불을 켤 수 있음.
    // 최대한 불을 밝힐 수 있는 방의 최대 개수

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    room = new ArrayList[N+1][N+1];
    light = new boolean[N+1][N+1];
    visited = new boolean[N+1][N+1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        room[i][j] = new ArrayList<>(); // 초기화
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      room[x][y].add(new Node(a, b));
    }

    Bfs();

    System.out.println(result);
  }

  private static void Bfs() {

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(1, 1));
    light[1][1] = true;
    visited[1][1] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      // 불을 켤 수 있는 방이 있다면 전부 켜준다.
      if (!room[node.x][node.y].isEmpty()) {

        // 방문을 초기화 해서 다시 방문 한다.
        visited = new boolean[N+1][N+1];
        visited[node.x][node.y] = true;

        for (Node n : room[node.x][node.y]) {
          // 불이 켜져있지 않은 방만 켜줌
          if (!light[n.x][n.y]) {
            light[n.x][n.y] = true;
            result++;
          }
        }

        room[node.x][node.y].clear(); // 켤 수 있는 곳을 다 켰기 때문에 없애줌
      }

      // 불이 켜져있고 방문을 하지 않았으면 방문한다.
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx > N || ny > N || nx <= 0 || ny <= 0) continue;

        if (light[nx][ny] && !visited[nx][ny]) {
          queue.add(new Node(nx, ny));
          visited[nx][ny] = true;
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