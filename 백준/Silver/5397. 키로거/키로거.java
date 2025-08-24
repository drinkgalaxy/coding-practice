import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      String line = br.readLine();

      Stack<Character> left = new Stack<>();
      Stack<Character> right = new Stack<>();

      for (char c : line.toCharArray()) {
        if (c == '<') {
          if (!left.isEmpty()) {
            right.push(left.pop());
          }
        } else if (c == '>') {
          if (!right.isEmpty()) {
            left.push(right.pop());
          }
        } else if (c == '-') {
          if (!left.isEmpty()) {
            left.pop();
          }
        } else {
          left.push(c);
        }
      }

      StringBuilder pwd = new StringBuilder();
      for (char c : left) {
        pwd.append(c);
      }

      while (!right.isEmpty()) {
        pwd.append(right.pop());
      }

      sb.append(pwd).append("\n");
    }
    System.out.println(sb);
  }
}