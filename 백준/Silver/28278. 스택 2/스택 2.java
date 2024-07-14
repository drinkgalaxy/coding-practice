
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String order = br.readLine();
            if (order.startsWith("1")) {
                int x = Integer.parseInt(order.split(" ")[1]);
                stack.push(String.valueOf(x));
            } else if (order.equals("2")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (order.equals("3")) {
                sb.append(stack.size()).append("\n");
            } else if (order.equals("4")) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (order.equals("5")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}