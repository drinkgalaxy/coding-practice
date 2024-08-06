import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] team;
    public static boolean[] visited;
    public static int N;
    public static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        team = new int[N][N];
        visited = new boolean[N];

        // 능력치 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 스타트 팀으로 결정할 번호 N/2 개 고르기. 그럼 나머지는 링크 팀
        Dfs(0, 0);

        System.out.println(minValue);

    }

    public static void Dfs(int idx, int depth) {

        if (depth == N / 2) {
            calculate();
            return;
        }

        // Dfs 진행
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Dfs(i + 1, depth + 1);
                // 재귀가 끝나면 초기화
                visited[i] = false;
            }
        }
    }

    public static void calculate() {
        int startValue = 0;
        int linkValue = 0;

        // 중복되지 않게 for 문을 돌아야 함
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startValue += team[i][j];
                    startValue += team[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkValue += team[i][j];
                    linkValue += team[j][i];
                }
            }
        }
        int val = Math.abs(startValue - linkValue);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        minValue = Math.min(minValue, val);

    }
}