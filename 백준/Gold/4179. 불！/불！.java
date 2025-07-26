import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static char[][] miro;
  static int[][] jihunDist;
  static int[][] fireDist;
  static int jihunCount = -1;
  static Queue<Node> jihunQueue = new LinkedList<>();
  static Queue<Node> fireQueue = new LinkedList<>();
  static int R, C;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    miro = new char[R][C];
    jihunDist = new int[R][C];
    fireDist = new int[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        miro[i][j] = line.charAt(j);
        jihunDist[i][j] = -1;
        fireDist[i][j] = -1;

        if (miro[i][j] == 'J') {
          jihunQueue.add(new Node(i, j));
          jihunDist[i][j] = 1;
        } else if (miro[i][j] == 'F') {
          fireQueue.add(new Node(i, j));
          fireDist[i][j] = 1;
        }
      }
    }

    getFireCount(); // 불의 확산시간 부터 체크해야 함
    getJihunCount();

    if (jihunCount == -1) {
      System.out.println("IMPOSSIBLE");
    } else {
      System.out.println(jihunCount);
    }

    // 지훈이의 초기위치부터 탈출구까지 걸리는 시간 구하기
    // 불의 초기위치부터 탈출구까지 퍼지는 시간 구하기
    // 두개를 비교했을 때 결괏값 출력

  }

  private static void getJihunCount() {
    while (!jihunQueue.isEmpty()) {
      Node node = jihunQueue.poll();

      // 지훈이의 결과 종료 조건, 현재 위치가 가장자리면 탈출
      if (node.x == 0 || node.y == 0 || node.x == R-1 || node.y == C-1) {
        jihunCount = jihunDist[node.x][node.y];
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];
        if (nx < R && nx >= 0 && ny < C && ny >= 0) {
          if (miro[nx][ny] == '.' && jihunDist[nx][ny] == -1
              && (fireDist[nx][ny] == -1 || jihunDist[node.x][node.y] + 1 < fireDist[nx][ny])) {
            // 불이 아직 안퍼졌거나, 지훈이 도착시간이 더 빠를때만 가능
            jihunQueue.add(new Node(nx, ny));
            jihunDist[nx][ny] = jihunDist[node.x][node.y] + 1;
          }
        }
      }
    }
  }

  private static void getFireCount() {
    while (!fireQueue.isEmpty()) {
      Node node = fireQueue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];
        if (nx < R && nx >= 0 && ny < C && ny >= 0) {
          if (miro[nx][ny] == '.' && fireDist[nx][ny] == -1) {
            fireQueue.add(new Node(nx, ny));
            fireDist[nx][ny] = fireDist[node.x][node.y] + 1;
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