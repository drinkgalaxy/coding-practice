import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] dist;
    static int sx, sy, ex, ey, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            L = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            dist = new int[L][L];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            System.out.println(BFS());
        }
    }

    private static int BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        dist[sx][sy] = 0; // 시작점은 거리가 0

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            // 도착지에 도착했을 경우
            if (nx == ex && ny == ey) {
                return dist[ex][ey];
            }

            for (int i = 0; i < 8; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];

                if (xx < L && yy < L && xx >= 0 && yy >= 0) {
                    if (dist[xx][yy] == 0) {
                        queue.offer(new int[]{xx, yy});
                        dist[xx][yy] += dist[nx][ny] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
