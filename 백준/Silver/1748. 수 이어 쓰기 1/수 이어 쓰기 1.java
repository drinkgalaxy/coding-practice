import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int result = 0;
    int plus = 1; // 자릿수에 더하는 값
    int num = 10;

    for (int i = 1; i <= N; i++) {
      if (i % num == 0) {
        plus++;
        num *= 10;
      }
      result += plus;
    }

    System.out.println(result);
  }
}