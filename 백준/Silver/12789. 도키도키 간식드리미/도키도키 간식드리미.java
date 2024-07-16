
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        Deque<Integer> wait = new ArrayDeque<>();
        Deque<Integer> space = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wait.offer(Integer.parseInt(st.nextToken()));
        }

        while (!wait.isEmpty() || !space.isEmpty()) {
            // count -> 번호표와 같은 경우 간식을 배부함
            if (!wait.isEmpty() && wait.peek() == count) {
                wait.poll();
                count++;
            } else if (!space.isEmpty() && space.peek() == count) {
                space.pop();
                count++;
            } else if (!wait.isEmpty()) {
                space.push(wait.poll());
            } else {
                break;
            }
        }

        if (count == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}