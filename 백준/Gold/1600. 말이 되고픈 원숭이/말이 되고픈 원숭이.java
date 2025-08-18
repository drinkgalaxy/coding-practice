import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int W, H;
  static int[][] miro;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] dy2 = {1, 2, 2, 1, -1, -2, -2, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken()); // 가로길이, 즉 col
    H = Integer.parseInt(st.nextToken()); // 세로 길이, 즉 row

    miro = new int[H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        miro[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 맨 왼쪽 위 = 0, 0
    // 맨 오른쪽 아래 = H-1, W-1

    System.out.println(Bfs(K));

  }

  private static int Bfs(int K) {

    int[][][] distance = new int[H][W][K+1];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        for (int k = 0; k <= K; k++) {
          distance[i][j][k] = -1;
        }
      }
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0, 0));
    distance[0][0][0] = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.x == H-1 && node.y == W-1) {
        return distance[node.x][node.y][node.k];
      }

      if (node.k < K) {
        // 말 행동 따라 움직이기
        for (int i = 0; i < 8; i++) {
          int nx = dx2[i] + node.x;
          int ny = dy2[i] + node.y;
          if (nx < H && ny < W && nx >= 0 && ny >= 0) {
            if (distance[nx][ny][node.k + 1] == -1 && miro[nx][ny] == 0) {
              queue.add(new Node(nx, ny, node.k + 1));
              distance[nx][ny][node.k + 1] = distance[node.x][node.y][node.k] + 1;
            }
          }
        }
      }

      // 인접한 칸만 움직이기
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < H && ny < W && nx >= 0 && ny >= 0) {
          if (distance[nx][ny][node.k] == -1 && miro[nx][ny] == 0) {
            queue.add(new Node(nx, ny, node.k));
            distance[nx][ny][node.k] = distance[node.x][node.y][node.k] + 1;
          }
        }
      }
    }

    return -1;
  }

  private static class Node {
    int x;
    int y;
    int k;

    public Node(int x, int y, int k) {
      this.x = x;
      this.y = y;
      this.k = k;
    }
  }
}