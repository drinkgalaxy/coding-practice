import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0}; // 아래, 위, 왼쪽, 오른쪽
    static int N, count;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new char[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        // 데이터 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j);

                    result.add(count);
                    count = 0; // 저장 후 초기화
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == '1') {
                count++;
                dfs(nx, ny);
            }
        }
    }
}