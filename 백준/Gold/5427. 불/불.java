import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  static int w, h;
  static char[][] apart;
  static int[][] fireDist;
  static int[][] resultDist;
  static Queue<Node> fireQueue;
  static Queue<Node> resultQueue;
  static int time = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      time = 0;
      apart = new char[h][w];
      fireDist = new int[h][w];
      resultDist = new int[h][w];
      fireQueue = new LinkedList<>();
      resultQueue = new LinkedList<>();

      for (int j = 0; j < h; j++) {
        for (int k = 0; k < w; k++) {
          fireDist[j][k] = -1;
          resultDist[j][k] = -1;
        }
      }

      for (int j = 0; j < h; j++) {
        String line = br.readLine();
        for (int k = 0; k < w; k++) {
          apart[j][k] = line.charAt(k);
          if (apart[j][k] == '@') {
            resultQueue.add(new Node(j, k, 0));
            resultDist[j][k] = 0;
          } else if (apart[j][k] == '*') {
            fireQueue.add(new Node(j, k, 0));
            fireDist[j][k] = 0;
          }
        }
      }

      fireBfs();
      resultBfs();

      if (time == 0) {
        sb.append("IMPOSSIBLE").append("\n");
      } else {
        sb.append(time).append("\n");
      }

    }
    System.out.println(sb);
  }

  private static void resultBfs() {

    while (!resultQueue.isEmpty()) {
      Node node = resultQueue.poll();

      if (node.x == h-1 || node.y == w-1 || node.x == 0 || node.y == 0) {
        time = node.time + 1;
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < h && nx >= 0 && ny < w && ny >= 0 && resultDist[nx][ny] == -1) {
          if (apart[nx][ny] != '#') {
            if (fireDist[nx][ny] == -1 || resultDist[node.x][node.y] + 1 < fireDist[nx][ny]) {
              resultQueue.add(new Node(nx, ny, node.time + 1));
              resultDist[nx][ny] = resultDist[node.x][node.y] + 1;
            }
          }

        }
      }
    }
  }

  private static void fireBfs() {

    while (!fireQueue.isEmpty()) {

      Node node = fireQueue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + node.x;
        int ny = dy[i] + node.y;
        if (nx < h && nx >= 0 && ny < w && ny >= 0 && fireDist[nx][ny] == -1) {
          if (apart[nx][ny] == '.' || apart[nx][ny] == '*' || apart[nx][ny] == '@') {
            apart[nx][ny] = '*';
            fireQueue.add(new Node(nx, ny, node.time + 1));
            fireDist[nx][ny] = fireDist[node.x][node.y] + 1;
          }
        }
      }
    }
  }

  private static class Node {
    int x, y;
    int time;

    public Node(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }
}