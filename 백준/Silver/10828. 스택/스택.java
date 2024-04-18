import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // 여기서 StringBuilder는 결과를 모아두었다가 한번에 출력해주는 역할.

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            if (S.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (S.equals("pop")) {
                if (!stack.empty()) {
                    sb.append(stack.pop());
                    sb.append("\n");
                } else {
                    sb.append(-1);
                    sb.append("\n");
                }
            } else if (S.equals("size")) {
                sb.append(stack.size());
                sb.append("\n");
            } else if (S.equals("empty")) {
                if (stack.empty()) {
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if (S.equals("top")) {
                if (stack.empty()) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(stack.peek());
                    sb.append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
