
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String order = br.readLine();
            if (order.startsWith("1")) {
                deque.offerFirst(order.split(" ")[1]);
            } else if (order.startsWith("2")) {
                deque.offerLast(order.split(" ")[1]);
            } else if (order.equals("3")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (order.equals("4")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (order.equals("5")) {
                sb.append(deque.size()).append("\n");
            } else if (order.equals("6")) {
                if (!deque.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (order.equals("7")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (order.equals("8")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}