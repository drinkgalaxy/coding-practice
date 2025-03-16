import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
    "l", "n", "m", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    String question = br.readLine();

    Map<String, Integer> map = new HashMap<>();
    for (String a : alphabet) {
      map.put(a, 0);
    }

    for (String q : question.split("")) {
      map.put(q, map.get(q) + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer value : map.values()) {
      sb.append(value).append(" ");
    }
    
    System.out.println(sb);
  }
}
