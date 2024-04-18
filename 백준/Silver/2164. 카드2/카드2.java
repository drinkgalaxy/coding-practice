import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        for (int i = 0; i < N-1; i++) {
            if (!queue.isEmpty()) {
                queue.poll();
                int front = queue.peek();
                queue.add(front);
                queue.remove();
            }
        }
        System.out.println(queue.peek());
    }
}
