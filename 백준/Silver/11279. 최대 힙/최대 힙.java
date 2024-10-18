import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(n);
            }
        }
        System.out.println(sb);
    }
}
