import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;
  static char[][] image;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    image = new char[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        image[i][j] = line.charAt(j);
      }
    }

    quad(image, 0, 0, N);

    System.out.println(sb);
  }

  static void quad(char[][] image, int x, int y, int size) {
    if (IsPossible(image, x, y, size, image[x][y])) {
      sb.append(image[x][y]);
      return;
    }

    sb.append("(");
    quad(image, x, y, size / 2);
    quad(image, x, y + size / 2, size / 2);
    quad(image, x + size / 2, y, size / 2);
    quad(image, x + size / 2, y + size / 2, size / 2);
    sb.append(")");
  }

  static boolean IsPossible(char[][] image, int x, int y, int size, int val) {
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (image[i][j] != val) {
          return false;
        }
      }
    }
    return true;
  }
}