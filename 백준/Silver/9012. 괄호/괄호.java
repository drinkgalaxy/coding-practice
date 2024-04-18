import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Stack<String> stack = new Stack<>();
            for (String s : str.split("")) {
                if (s.equals(")")) {
                    if (!stack.empty()) {
                        if (stack.peek() != "no") {
                            stack.pop();
                        }
                    } else {
                        stack.push("no");
                    }
                } else if (s.equals("(")){
                    stack.push(s);
                }
            }
            if (stack.empty()) {
                sb.append("YES");
                sb.append("\n");
            } else {
                sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
