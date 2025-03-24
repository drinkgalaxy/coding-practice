import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder result = new StringBuilder();

    List<String> list = new ArrayList<>();

    String input = "";
    String answer = "";
    while ((input = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(input);
      while (st.hasMoreTokens()) {
        String s = st.nextToken();

        if (s.equals("<br>")) {
          result.append(answer.trim()).append("\n");
          answer = "";
        } else if (s.equals("<hr>")) {
          if (answer.length() != 0) {
            result.append(answer.trim()).append("\n");
            answer = "";
          }
          result.append("-".repeat(80)).append("\n");
        } else {
          if ((answer + s).length() > 80) {
            result.append(answer.trim()).append("\n");
            answer = "";
          }
          answer += (s + " ");
        }
      }
    }
    System.out.println(result + answer.trim());
  }
}
