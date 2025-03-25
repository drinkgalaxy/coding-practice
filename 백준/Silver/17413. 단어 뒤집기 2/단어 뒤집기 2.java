import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    String S = br.readLine();

    boolean tag = false;

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '<') {

        // stack 에 저장된 것 부터 result.append
        while (!stack.isEmpty()) {
          result.append(stack.pop());
        }

        tag = true;
      } else if (S.charAt(i) == '>') {
        tag = false;
        result.append(S.charAt(i));
      }

      if (tag) {
        result.append(S.charAt(i));
      } else {
        if (S.charAt(i) != '>') {

          if (S.charAt(i) == ' ') {
            while (!stack.isEmpty()) {
              result.append(stack.pop());
            }
            result.append(" ");
          } else {
            stack.push(S.charAt(i));
          }
        }
      }
    }

    // 남은 거 출력
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    // result 출력
    System.out.println(result);
  }
}
