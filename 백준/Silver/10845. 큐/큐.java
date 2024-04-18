import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            if (S.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (S.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll());
                    sb.append("\n");
                } else {
                    sb.append(-1);
                    sb.append("\n");
                }
            } else if (S.equals("size")) {
                sb.append(queue.size());
                sb.append("\n");
            } else if (S.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if (S.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek());
                    sb.append("\n");
                } else {
                    sb.append(-1);
                    sb.append("\n");
                }
            } else if (S.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(((LinkedList<Integer>) queue).peekLast());
                    sb.append("\n");
                } else {
                    sb.append(-1);
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
