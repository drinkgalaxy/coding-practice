import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] game = new int[101];
    static int[] count = new int[101];
    static boolean[] visited = new boolean[101];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 사다리의 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < N; i++) { // 사다리
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // x에 도착하면 y로 이동
            game[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            game[u] = v;
        }

        BFS();
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작은 1에서부터
        visited[1] = true;
        count[1] = 0;
        
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == 100) {
                System.out.println(count[n]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = n + i;
                if (x > 100) {
                    continue;
                }
                if (visited[x]) {
                    continue;
                }

                visited[x] = true;
                if (game[x] != 0) { // 사다리나 뱀이 있는 칸이면
                    if (!visited[game[x]]) {
                        queue.offer(game[x]);
                        visited[game[x]] = true;
                        count[game[x]] = count[n] + 1;
                    }
                } else {
                    queue.offer(x);
                    visited[x] = true;
                    count[x] = count[n] + 1;
                }

            }
        }
    }
}
