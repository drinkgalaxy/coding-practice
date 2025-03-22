import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String word;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    word = br.readLine();

    System.out.println(check() ? 1 : 0);

  }

  private static boolean check() {
    int s = 0;
    int e = word.length()-1;

    while (s < e) {
      if (word.charAt(s) != word.charAt(e)) {
        return false;
      }
      s++;
      e--;
    }
    return true;
  }
}
