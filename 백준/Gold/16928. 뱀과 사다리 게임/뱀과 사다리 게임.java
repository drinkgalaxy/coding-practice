import java.io.*;
import java.util.*;

public class Main {
    static int count[] = new int[101];
    static int ladderAndSnake[] = new int[101];
    static boolean visited[] = new boolean[101];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 사다리의 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // x번 칸에 도착하면, y번 칸으로 이동
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladderAndSnake[x] = y;

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // u번 칸에 도착하면, v번 칸으로 이동
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ladderAndSnake[u] = v;
        }

        bfs();

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작
        count[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == 100) {
                System.out.println(count[n]); // 100 이면 횟수 바로 리턴
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int x = n + i; // 1부터 6까지 이동
                if (x > 100) {
                    continue; // 더했을 때 100보다 크면 그 경우는 무시
                }
                if (visited[x]) { // 방문한 칸이여도 그 경우는 무시
                    continue;
                }
                visited[x] = true;

                if (ladderAndSnake[x] != 0) { // 사다리 또는 뱀위 위치일 때
                    if (!visited[ladderAndSnake[x]]) {
                        queue.offer(ladderAndSnake[x]);
                        visited[ladderAndSnake[x]] = true;
                        count[ladderAndSnake[x]] = count[n] + 1;
                    }
                } else { // 아무것도 아닐 때 그 칸으로 이동하여 큐에 추가
                    queue.offer(x);
                    visited[x] = true;
                    count[x] = count[n] + 1;
                }
            }
        }
    }

}