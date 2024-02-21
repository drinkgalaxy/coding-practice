import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int temp = 1;
    static boolean err = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 입력받을 수열 크기
        Stack<Integer> stack = new Stack<>();
        // 원하는 숫자가 나올 때까지 push
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(br.readLine());
            for (; temp <= n; temp++) {
                stack.push(temp);
                sb.append("+\n");
            }
            // 해당 숫자가 나왔다면, 그 숫자 pop
            if (stack.peek() == n) {
                stack.pop();
                sb.append("-\n");
            } else { // 해당 숫자가 나오지 않았다면, err를 true로 변경
                err = true;
            }

        }
        // 출력하기
        if (err) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
