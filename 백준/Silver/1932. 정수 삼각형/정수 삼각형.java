import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Integer[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 삼각형의 크기

        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;
        // 데이터 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 삼각형 맨 밑의 값으로 초기화
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(getMax(0, 0));
    }

    public static int getMax(int depth, int index) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if (depth == N - 1) {
            return dp[depth][index];
        }

        // 탐색하지 않은 값에 메모이제이션 저장
        if (dp[depth][index] == null) {
            dp[depth][index] = Math.max(getMax(depth + 1, index), getMax(depth + 1, index + 1)) + arr[depth][index];
        }

        // 리턴
        return dp[depth][index];
    }

}
