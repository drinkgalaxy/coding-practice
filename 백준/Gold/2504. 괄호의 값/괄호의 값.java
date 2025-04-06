import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    Stack<Character> stack = new Stack<>();

    int result = 0;
    int temp = 1;
    boolean isValid = true;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (c == '(') { // case 1
        temp *= 2;
        stack.push(c);
      } else if (c == '[') { // case 2
        temp *= 3;
        stack.push(c);
      } else if (c == ')') { // case 3
        if (stack.isEmpty() || stack.peek() != '(') {
          isValid = false;
          break;
        }

        if (input.charAt(i-1) == '(') {
          result += temp;
        }

        temp /= 2;
        stack.pop();
      } else if (c == ']') { // case 4
        if (stack.isEmpty() || stack.peek() != '[') {
          isValid = false;
          break;
        }

        if (input.charAt(i-1) == '[') {
          result += temp;
        }

        temp /= 3;
        stack.pop();
      }
    }

    System.out.println(isValid && stack.isEmpty() ? result : 0);
  }
}