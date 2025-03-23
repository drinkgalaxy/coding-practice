import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    while (N > 1) {
      int n = div(N);
      if (n != 1) {
        N /= n;
        result.append(n).append("\n");
      }
    }
    System.out.println(result);
  }

  private static int div(int N) {
    for (int i = 2; i <= N; i++) {
      if (N % i == 0) {
        return i;
      }
    }
    return 1;
  }
}
