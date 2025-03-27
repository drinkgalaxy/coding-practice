import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int current = 1;
    for (int num : arr) {
      while (current <= num) {
        stack.push(current++);
        sb.append("+").append("\n");
      }

      if (stack.peek() == num) {
        stack.pop();
        sb.append("-").append("\n");
      } else {
        System.out.println("NO");
        return;
      }
    }
    System.out.println(sb);
  }
}
