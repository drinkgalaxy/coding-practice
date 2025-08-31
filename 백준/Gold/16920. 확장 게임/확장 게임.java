import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M, P;
  static char[][] board;
  static int[] dx = {0, -1, 1, 0};
  static int[] dy = {1, 0, 0, -1};
  static int[] S; // 플레이어별 확장 가능 거리
  static int[] result; // 플레이어별 성 개수
  static Queue<Player>[] queue; // 플레이어별 Bfs 큐
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    board = new char[N][M];
    S = new int[P+1];
    result = new int[P+1];
    queue = new LinkedList[P+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= P; i++) {
      S[i] = Integer.parseInt(st.nextToken());
      queue[i] = new LinkedList<>();
    }

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = line.charAt(j);
        if (board[i][j] >= '1' && board[i][j] <= '9') {
          int p = board[i][j] - '0';
          result[p]++; // 초기 성 개수 저장
          queue[p].add(new Player(i, j, 0));
        }
      }
    }

    Bfs();

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= P; i++) {
      sb.append(result[i]).append(" ");
    }
    System.out.println(sb);
  }

  private static void Bfs() {

    while (true) {

      boolean isGaming = false;

      for (int p = 1; p <= P; p++) {

        Queue<Player> next = new LinkedList<>();

        while (!queue[p].isEmpty()) {
          Player poll = queue[p].poll();

          if (poll.dist == S[p]) {
            next.add(new Player(poll.x, poll.y, 0)); // 확장 가능 거리 초과했으면 다음 라운드로 초기화
            continue;
          }

          for (int i = 0; i < 4; i++) {
            int nx = dx[i] + poll.x;
            int ny = dy[i] + poll.y;
            if (nx < N && ny < M && nx >= 0 && ny >= 0) {
              if (board[nx][ny] == '.') {
                board[nx][ny] = (char) (p + '0');
                result[p]++; // 플레이어별 성 개수 증가
                queue[p].add(new Player(nx, ny,poll.dist + 1));
                isGaming = true;
              }
            }
          }
        }

        queue[p] = next; // 다음 라운드 준비
      }

      if (!isGaming) {
        return;
      }
    }
  }

  private static class Player {
    int x, y;
    int dist;

    public Player(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

  }
}