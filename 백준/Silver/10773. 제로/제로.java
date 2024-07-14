
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Long> stack = new ArrayDeque<>();

        long K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            long number = Integer.parseInt(br.readLine());
            if (number == 0L) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        long count = 0L;
        while (!stack.isEmpty()) {
            count += stack.pop();
        }

        System.out.println(count);
    }
}