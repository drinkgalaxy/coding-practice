import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != ' ') {
        if (Character.isUpperCase(str.charAt(i))) {
          ROT13(str.charAt(i) - 'A', true);
        } else if (Character.isLowerCase(str.charAt(i))) {
          ROT13(str.charAt(i) - 'a', false);
        } else {
          sb.append(str.charAt(i));
        }
      } else {
        sb.append(" ");
      }
    }

    System.out.println(sb);
  }

  private static void ROT13(int tmp, boolean isUpper) {
    sb.append(isUpper ? ((char) ((tmp + 13) % 26 + 'A')) : ((char) ((tmp + 13) % 26 + 'a')));
  }
}