import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<ABS> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll().toString()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else {
                queue.offer(new ABS(num));
            }
        }

        System.out.println(sb);
    }

    static public class ABS implements Comparable<ABS> {
        int num;

        public ABS(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(ABS abs) {
            if (Math.abs(this.num) == Math.abs(abs.num)) {
                return this.num - abs.num;
            } else {
                return Math.abs(this.num) - Math.abs(abs.num);
            }
        }

        @Override
        public String toString() {
            return num+"";
        }
    }
}
