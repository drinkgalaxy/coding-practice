import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int M, N;
  static boolean[][] paper;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int area = 0;
  static List<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken()); // 행
    N = Integer.parseInt(st.nextToken()); // 열
    int K = Integer.parseInt(st.nextToken()); // K개 직사각형

    paper = new boolean[M][N];
    visited = new boolean[M][N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int leftDownX = Integer.parseInt(st.nextToken());
      int leftDownY = Integer.parseInt(st.nextToken());
      int rightUpX = Integer.parseInt(st.nextToken());
      int rightUpY = Integer.parseInt(st.nextToken());
      
      changeStatus(leftDownX, leftDownY, rightUpX, rightUpY);
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (!paper[i][j] && !visited[i][j]) {
          area++;
          Bfs(i, j);
        }
      }
    }

    sb.append(area).append("\n");

    Collections.sort(list);
    for (Integer i : list) {
      sb.append(i).append(" ");
    }

    System.out.println(sb);
  }

  private static void Bfs(int x, int y) {

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    visited[x][y] = true;
    int pArea = 1;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;

        if (nx < M && ny < N && nx >= 0 && ny >= 0) {
          if (!paper[nx][ny] && !visited[nx][ny]) {
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
            pArea++; 
          }
        }
      }
    }

    list.add(pArea);
  }

  private static void changeStatus(int leftDownX, int leftDownY, int rightUpX, int rightUpY) {
    for (int i = leftDownY; i < rightUpY; i++) {
      for (int j = leftDownX; j < rightUpX; j++) {
        paper[i][j] = true;
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