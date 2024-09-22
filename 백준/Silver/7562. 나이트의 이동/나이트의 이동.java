import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int L;
    static int[][] arr;
    static boolean[][] visited;
    // 나이트가 이동할 수 있는 dx, dy 저장
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int x1, y1, x2, y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            L = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            arr = new int[L][L];
            visited = new boolean[L][L];

            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];

                if (xx >= 0 && xx < L && yy >= 0 && yy < L) {
                    if (!visited[xx][yy]) {
                        arr[xx][yy] = arr[nx][ny] + 1;

                        queue.add(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
    }
}