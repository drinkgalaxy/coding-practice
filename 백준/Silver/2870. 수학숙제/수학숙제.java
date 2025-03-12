import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    List<BigInteger> numbers = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String paper = br.readLine();
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < paper.length(); j++) {
        if (Character.isDigit(paper.charAt(j))) { // 숫자인 경우
          sb.append(paper.charAt(j));
        } else {
          if (sb.length() > 0) {
            numbers.add(new BigInteger(sb.toString()));
            sb = new StringBuilder();
          }
        }
      }

      if (sb.length() > 0) {
        numbers.add(new BigInteger(sb.toString()));
      }
    }

    Collections.sort(numbers);

    for (BigInteger number : numbers) {
      System.out.println(number);
    }
  }
}
