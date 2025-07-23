import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static char[][] miro;
    static int[][] dist;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][M];
        miro = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1; // 방문 여부 초기화
            }
        }

        dist[0][0] = 1; // 출발 지점
        BFS(0, 0);

        System.out.println(dist[N-1][M-1]);

    }

    private static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + n.s;
                int ny = dy[i] + n.e;

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (dist[nx][ny] == -1 && miro[nx][ny] == '1') {
                        dist[nx][ny] = dist[n.s][n.e] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }

        }
    }

    public static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
