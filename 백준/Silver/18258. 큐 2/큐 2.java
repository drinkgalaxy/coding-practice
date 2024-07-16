
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String order = br.readLine();
            if (order.contains("push")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                queue.offer(number);
            } else if (order.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (order.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (order.equals("empty")) {
                if (!queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (order.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (order.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.getLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}