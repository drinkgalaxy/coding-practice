import java.io.*;
import java.util.*;

public class Main {
    static int[][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M, N;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // col
        N = Integer.parseInt(st.nextToken()); // row
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }

        bfs();
    }

    static public void bfs() {
        int date = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            date = n.date;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        queue.offer(new Node(nx, ny, date + 1));
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

    static public boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static public class Node {
        int x, y, date;

        public Node(int x, int y, int date) {
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }
}