import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] paper;
  static int[] result = new int[2];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    quad(0, 0, N);

    System.out.println(result[0]);
    System.out.println(result[1]);

  }

  private static void quad(int x, int y, int size) {
    if (isAllSame(paper[x][y], x, y, size)) {
      if (paper[x][y] == 0) {
        result[0]++;
      } else {
        result[1]++;
      }
      return;
    }

    int newSize = size / 2;

    quad(x, y, newSize);
    quad(x, y + newSize, newSize);
    quad(x + newSize, y, newSize);
    quad(x + newSize, y + newSize, newSize);
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