import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 가로칸의 수 c
        N = Integer.parseInt(st.nextToken()); // 세로칸의 수 r
        H = Integer.parseInt(st.nextToken()); // 주어지는 높이

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 토마토 입력 받기 및 익은 토마토를 큐에 추가
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        queue.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }

        // BFS 실행
        bfs();
    }

    public static void bfs() {
        int date = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            date = n.date;
            for (int j = 0; j < 6; j++) {
                int nh = dh[j] + n.h;
                int nx = dx[j] + n.x;
                int ny = dy[j] + n.y;
                if (nh >= 0 && nx >= 0 && ny >= 0 && nh < H && nx < N && ny < M) {
                    if (tomato[nh][nx][ny] == 0) {
                        tomato[nh][nx][ny] = 1;
                        queue.offer(new Node(nh, nx, ny, date+1));
                    }
                }
            }
        }

        if (check()) {
            System.out.println(date);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 안익은 토마토가 있으면
                    if (tomato[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static class Node {
        int h, x, y, date;

        public Node(int h, int x, int y, int date) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }
}