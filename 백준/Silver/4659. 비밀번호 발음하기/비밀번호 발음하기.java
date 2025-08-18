import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    String input = "";
    while (true) {
      input = br.readLine();

      if (input.equals("end")) {
        break;
      }

      if (isContainsVowels(input) && !isThreeConsecutive(input) && !isSameConsecutiveWords(input)) {
        sb.append("<").append(input).append(">").append(" is acceptable.").append("\n");
      } else {
        sb.append("<").append(input).append(">").append(" is not acceptable.").append("\n");
      }
    }

    System.out.println(sb);
  }

  // 모음 하나 이상 포함
  private static boolean isContainsVowels(String input) {

    List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    for (int i = 0; i < input.length(); i++) {
      if (list.contains(input.charAt(i))) {
        return true;
      }
    }

    return false;
  }

  // 연속된 모음, 자음 3개 이상 x
  private static boolean isThreeConsecutive(String input) {

    String vowels = "aeiou";
    int vowelCount = 0;
    int consonantCount = 0;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (vowels.indexOf(c) != -1) {
        vowelCount++;
        consonantCount = 0;
      } else {
        consonantCount++;
        vowelCount = 0;
      }

      if (vowelCount == 3 || consonantCount == 3) {
        return true;
      }
    }

    return false;
  }

  // 연속된 단어 2개 이상 x
  private static boolean isSameConsecutiveWords(String input) {

    for (int i = 1; i < input.length(); i++) {
      char prev = input.charAt(i-1);
      char now = input.charAt(i);

      if (prev == now) {
        if (prev == 'e' || prev == 'o') {
          continue;
        } else {
          return true;
        }
      }
    }

    return false;
  }
}