import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 시작
        int K = Integer.parseInt(st.nextToken()); // 도착

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            // 동생을 찾은 경우
            if (n.idx == K) {
                System.out.println(n.time);
                return;
            }

            if (n.idx*2 <= 100000 && !visited[n.idx*2]) {
                queue.offer(new Node(n.idx*2, n.time));
                visited[n.idx*2] = true;
            }

            if (n.idx-1 >= 0 && !visited[n.idx-1]) {
                queue.offer(new Node(n.idx-1, n.time+1));
                visited[n.idx-1] = true;
            }

            if (n.idx+1 <= 100000 && !visited[n.idx+1]) {
                queue.offer(new Node(n.idx+1, n.time+1));
                visited[n.idx+1] = true;
            }
        }
    }

    public static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}