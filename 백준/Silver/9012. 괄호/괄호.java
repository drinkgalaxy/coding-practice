
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            stack = new ArrayDeque<>();
            for (String s : ps.split("")) {
                if (s.equals("(")) {
                    stack.push(s);
                } else {
                    if (stack.peek() != null && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }
}