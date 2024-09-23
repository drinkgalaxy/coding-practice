import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] tomato;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 좌우상하
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 가로칸의 수 c
        N = Integer.parseInt(st.nextToken()); // 세로칸의 수 r
        tomato = new int[N][M];
        visited = new boolean[N][M];

        // 토마토 입력 받기 및 익은 토마토를 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
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

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.offer(new Node(nx, ny, date+1));
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안익은 토마토가 있으면
                if (tomato[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node {
        int x, y, date;

        public Node(int x, int y, int date) {
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }
}