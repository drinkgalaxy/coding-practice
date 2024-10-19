import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] tomato;
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // 좌, 우, 상, 하, 앞, 뒤
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로칸의 수 = col
        N = Integer.parseInt(st.nextToken()); // 세로칸의 수 = row
        H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 높이

        tomato = new int[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[k][i][j] == 1) {
                        queue.offer(new Node(k, i, j, 0));
                    }
                }
            }
        }

        BFS();
    }

    public static void BFS() {
        int date = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            date = n.date;
            for (int i = 0; i < 6; i++) {
                int h = dh[i] + n.h;
                int x = dx[i] + n.x;
                int y = dy[i] + n.y;
                if (x < N && x >= 0 && y < M && y >= 0 && h < H && h >= 0) {
                    if (tomato[h][x][y] == 0) {
                        tomato[h][x][y] = 1;
                        queue.offer(new Node(h, x, y, date + 1));
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

    private static boolean check() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[k][i][j] == 0) {
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
