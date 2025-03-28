import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    for (int i = 2; i <= Math.sqrt(N); i++) {
      while (N % i == 0) {
        result.append(i).append("\n");
        N /= i;
      }
    }
    if (N != 1) {
      result.append(N);
    }
    System.out.println(result);
  }
  
}
