import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      long N = Integer.parseInt(br.readLine());
      long result = 0;
      while (N >= 5) {
        result += N / 5;
        N /= 5;
      }
      sb.append(result).append("\n");
    }

    System.out.println(sb);
  }
}