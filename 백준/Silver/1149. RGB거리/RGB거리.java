import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 개수

        cost = new int[N][3];
        dp = new int[N][3];

        // 색깔 저장하기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 값 초기화
        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        // 값 출력
        System.out.println(Math.min(painted(N - 1, Red), Math.min(painted(N - 1, Green), painted(N - 1, Blue))));

    }

    public static int painted(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == Red) {
                dp[N][Red] = Math.min(painted(N - 1, Green), painted(N - 1, Blue)) + cost[N][Red];
            } else if (color == Green) {
                dp[N][Green] = Math.min(painted(N - 1, Red), painted(N - 1, Blue)) + cost[N][Green];
            } else {
                dp[N][Blue] = Math.min(painted(N - 1, Red), painted(N - 1, Green)) + cost[N][Blue];
            }
        }

        return dp[N][color];

    }
}
