import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] paper;
  static int N, m1, z, p1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 탐색 시작하기
    quad(0, 0, N);

    System.out.println(m1);
    System.out.println(z);
    System.out.println(p1);

  }
  private static void quad(int x, int y, int size) {
    // 종이가 모두 같은 수로 되어 있는지 확인
    if (isAllSame(paper[x][y], x, y, size)) {
      if (paper[x][y] == -1) {
        m1++;
      } else if (paper[x][y] == 0) {
        z++;
      } else {
        p1++;
      }
      return;
    }

    int newSize = size / 3;

    // 아니면 9개로 자르기

    quad(x, y, newSize);
    quad(x, y + newSize, newSize);
    quad(x, y + 2 * newSize, newSize);

    quad(x + newSize, y, newSize);
    quad(x + newSize, y + newSize, newSize);
    quad(x + newSize, y + 2 * newSize, newSize);

    quad(x + 2 * newSize, y, newSize);
    quad(x + 2 * newSize, y + newSize, newSize);
    quad(x + 2 * newSize, y + 2 * newSize, newSize);

  }

  private static boolean isAllSame(int val, int x, int y, int size) {
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (paper[i][j] != val) {
          return false;
        }
      }
    }
    return true;
  }
}