import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist = new int[100001]; // 이동가능한 위치의 최댓값
    static boolean[] visited = new boolean[100001];;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        // N 부터 K까지 가장 빠른 경로 구하기
        // K-N 부터 K 배열에서 X-1 또는 X+1, 2*X를 하면서 K까지 가는 가장 빠른 경로

        System.out.println(bfs(N));

    }

    private static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        visited[n] = true;
        queue.offer(n);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 동생을 찾은 경우
            if (current == K) {
                return dist[current];
            }

            // X-1의 경우
            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
                dist[current - 1] = dist[current] + 1;
            }

            // X+1의 경우
            if (current + 1 <= 100000 && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
                dist[current + 1] = dist[current] + 1;
            }

            // 2*X의 경우
            if (current * 2 <= 100000 && !visited[current * 2]) {
                queue.offer(current * 2);
                visited[current * 2] = true;
                dist[current * 2] = dist[current] + 1;
            }
        }
        return -1; // 안되는 경우는 없음
    }

}