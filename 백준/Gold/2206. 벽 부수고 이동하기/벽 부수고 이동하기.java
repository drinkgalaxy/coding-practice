import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][2]; // 3차원 배열

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 0,0 (1, 1) 부터 탐색 시작
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Space> queue = new LinkedList<>();
        queue.offer(new Space(0, 0, 1, 0)); // 처음 시작은 벽을 부수지 않고 방문.

        while (!queue.isEmpty()) {
            Space n = queue.poll();

            // 도착 지점에 도달했을 때 이동 거리 반환
            if (n.x == N - 1 && n.y == M - 1) {
                return n.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 벽을 부수지 않고 탐색하는 경우
                    if (!visited[nx][ny][n.destroyed] && map[nx][ny] == '0') {
                        queue.offer(new Space(nx, ny, n.count+1, n.destroyed));
                        visited[nx][ny][n.destroyed] = true;
                    }

                    // 벽을 부수고 탐색하는 경우
                    if (!visited[nx][ny][1] && n.destroyed == 0 && map[nx][ny] == '1') {
                        queue.offer(new Space(nx, ny, n.count+1, 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1; // 도착하지 못하면 -1반환
    }

    public static class Space {
        int x;
        int y;
        int count;
        int destroyed;

        public Space(int x, int y, int count, int d) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroyed = d;
        }
    }
}