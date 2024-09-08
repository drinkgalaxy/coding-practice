import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Integer[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 삼각형의 크기

        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기화 -> 삼각형 맨 밑의 값으로 초기화
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }
        System.out.println(getMax(0, 0));
    }

    private static int getMax(int depth, int index) {
        // 초기화된 맨 밑의 값이면
        if (depth == n - 1) {
            return dp[n - 1][index];
        }

        if (dp[depth][index] == null) {
            dp[depth][index] = Math.max(getMax(depth + 1, index) + arr[depth][index], getMax(depth + 1, index + 1) + arr[depth][index]);
        }

        return dp[depth][index];
    }
}
