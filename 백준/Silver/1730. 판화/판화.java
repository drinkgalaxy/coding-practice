import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static char[][] board;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    board = new char[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = '.';
      }
    }

    int x = 0;
    int y = 0;

    String movement = br.readLine();
    for (int i = 0; i < movement.length(); i++) {
      int[] m = move(movement.charAt(i));
      int nx = x + m[0];
      int ny = y + m[1];

      if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;

      if (m[0] != 0) { // 수직 방향
        vertical(x, y);
        vertical(nx, ny);
      } else if (m[1] != 0) { // 수평 방향
        horizontal(x, y);
        horizontal(nx, ny);
      }

      x = nx;
      y = ny;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(board[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static int[] move(char c) {
    if (c == 'U') {
      return new int[]{-1, 0}; // 위쪽
    } else if (c == 'D') {
      return new int[]{1, 0}; // 아래쪽
    } else if (c == 'L') {
      return new int[]{0, -1}; // 왼쪽
    } else {
      return new int[]{0, 1}; // 오른쪽
    }
  }

  private static void vertical(int a, int b) {
    if (board[a][b] == '.') {
      board[a][b] = '|';
    } else if (board[a][b] == '-') {
      board[a][b] = '+';
    }
  }

  private static void horizontal(int a, int b) {
    if (board[a][b] == '.') {
      board[a][b] = '-';
    } else if (board[a][b] == '|') {
      board[a][b] = '+';
    }
  }
}