import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String sentence = br.readLine();
    String search = br.readLine();

    int answer = 0;
    int index = 0;

    while (index <= sentence.length() - search.length()) {
      index = sentence.indexOf(search, index);
      if (index == -1) {
        break;
      } else {
        answer++;
        index += search.length();
      }

    }

    System.out.println(answer);
  }
}
 