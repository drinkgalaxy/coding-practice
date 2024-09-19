import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static char[][] miro;
    static int[][] dist; // 방문 배열 대신 최단 거리를 계산할 dist 배열
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 미로의 행 N
        M = Integer.parseInt(st.nextToken()); // 미로의 열 M
        miro = new char[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1; // 거리를 -1로 세팅해 방문여부 확인
            }
        }
        dist[0][0] = 1; // 첫 시작 (출발 지점 포함)
        bfs(0, 0);

        System.out.println(dist[N-1][M-1]); 
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (miro[nx][ny] == '1' && dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[n.x][n.y] + 1; // 한칸 이동했기 때문에, 이전 출발지점의 거리 + 1을 해줌
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}