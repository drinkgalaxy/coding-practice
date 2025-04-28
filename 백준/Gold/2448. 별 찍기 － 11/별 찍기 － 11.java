import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static char[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    // 삼각형 배열 세팅 : 행의 개수 N, 열의 개수 2 * N - 1
    arr = new char[N][2 * N - 1];

    // 배열 미리 공백으로 채워두기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2 * N - 1; j++) {
        arr[i][j] = ' ';
      }
    }

    star(0, N - 1, N); // 삼각형의 꼭대기는 N - 1

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2 * N - 1; j++) {
        sb.append(arr[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);

  }

  private static void star(int r, int c, int size) {
    if (size == 3) { // 가장 작은 삼각형
      arr[r][c] = '*';
      arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
      for (int i = -2; i <= 2; i++) {
        arr[r + 2][c + i] = '*';
      }

      return;
    }

    int newSize = size / 2;
    // 위쪽 삼각형
    star(r, c, newSize);
    // 왼쪽 아래 삼각형
    star(r + newSize, c - newSize, newSize);
    // 오른쪽 아래 삼각형
    star(r + newSize, c + newSize, newSize);
  }
}