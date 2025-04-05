import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String iron = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();

    int count = 0;

    for (int i = 0; i < iron.length(); i++) {
      if (iron.charAt(i) == '(') { // ( 일 경우
        stack.push(iron.charAt(i));
      } else { // ) 일 경우
        stack.pop();
        if (iron.charAt(i - 1) == '(') { // () 가 될 경우 레이저
          count += stack.size();
        } else { // )) 가 될 경우 마지막 조각을 합친 후 쇠막대기 종료
          count++;
        }
      }
    }

    System.out.println(count);
  }
}