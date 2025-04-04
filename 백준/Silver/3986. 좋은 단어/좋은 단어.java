import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int count = 0;

    for (int i = 0; i < N; i++) {
      Stack<String> stack = new Stack<>();
      for (String s : br.readLine().split("")) {
        if (stack.isEmpty()) { // 스택이 비어있다면
          stack.push(s);
        } else { // 스택이 비어있지 않다면
          if (s.equals("A")) { // 글자가 A 일 경우
            if (stack.peek().equals("A")) { // 앞 글자가 A 일 경우
              stack.pop();
            } else { // 앞 글자가 B 일 경우
              stack.push(s);
            }
          } else { // 글자가 B 일 경우
            if (stack.peek().equals("A")) { // 앞 글자가 A 일 경우
              stack.push(s);
            } else { // 앞 글자가 B 일 경우
              stack.pop();
            }
          }
        }
      }

      if (stack.isEmpty()) {
        count++;
      }
    }

    System.out.println(count);
  }
}