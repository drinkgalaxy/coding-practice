
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            Deque<String> stack = new ArrayDeque<>();
            for (String s : line.split(" ")) {
                for (String str : s.split("")) {
                    if (str.equals("(")) {
                        stack.push(str);
                    } else if (str.equals(")")) {
                        if (stack.peek() != null && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(str);
                        }
                    } else if (str.equals("[")) {
                        stack.push(str);
                    } else if (str.equals("]")) {
                        if (stack.peek() != null && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stack.push(str);
                        }
                    }
                }
            }
            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}