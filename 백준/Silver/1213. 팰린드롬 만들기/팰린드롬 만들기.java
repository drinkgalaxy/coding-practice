import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String name = br.readLine();

    int[] alphabet = new int[26];

    for (int i = 0; i < name.length(); i++) {
      alphabet[name.charAt(i) - 'A'] += 1;
    }

    int oddCount = 0;
    char oddChar = 0;
    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] % 2 == 1) {
        oddCount++;
        oddChar = (char) (i + 'A');
      }
    }

    StringBuilder result = new StringBuilder();
    if (oddCount > 1) {
      System.out.println("I'm Sorry Hansoo");
    } else {
      for (int i = 0; i < alphabet.length; i++) { // 앞 절반 만들기
        for (int j = 0; j < alphabet[i] / 2; j++) {
          result.append((char) (i + 'A'));
        }
      }

      if (oddChar == 0) {
        System.out.println(result.toString() + result.reverse().toString());
      } else {
        System.out.println(result.toString() + oddChar + result.reverse().toString());
      }
    }
  }
}
