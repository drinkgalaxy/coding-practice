import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int result = 0;
    int plus = 1;
    int digit = 10;

    for (int i = 1; i <= N; i++) {
      if (i % digit == 0) {
        plus++;
        digit *= 10;
      }
      result += plus;
    }

    System.out.println(result);
  }
}