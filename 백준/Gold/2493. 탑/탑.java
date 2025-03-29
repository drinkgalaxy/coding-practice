import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
 
    for (int i = 1; i <= N; i++) {
      // 들어있는 인덱스의 배열값이 새로 넣는 인덱스의 배열값보다 작으면 이전 인덱스 빼기
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }

      result.append(stack.isEmpty() ? 0 : stack.peek()).append(" ");
      stack.push(i);
    }

    System.out.println(result);
  }
}