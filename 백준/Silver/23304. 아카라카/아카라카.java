import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static final String YES = "AKARAKA";
  static final String NO = "IPSELENTI";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    System.out.println(isAkaraka(s) ? YES : NO);


  }

  private static boolean isAkaraka(String s) {
    if (s.length() <= 1) return true;

    if (!isPalindrome(s)) return false;

    int mid = s.length() / 2;
    return isAkaraka(s.substring(0, mid)) && isAkaraka(s.substring(s.length() - mid));
  }

  private static boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
