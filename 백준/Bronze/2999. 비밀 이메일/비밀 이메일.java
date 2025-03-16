import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String msg = br.readLine();

    int n = msg.length();
    int r = 0;
    int c = 0;

    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        r = i;
        c = (n / r);
      }
    }

    char[][] arr = new char[r][c];
    int index = 0;
    for (int i = 0; i < c; i++) {
      for (int j = 0; j < r; j++) {
        arr[j][i] = msg.charAt(index++);
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(arr[i][j]);
      }
    }
  }
}
