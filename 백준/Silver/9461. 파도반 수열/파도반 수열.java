import java.io.*;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 각 테스트 케이스
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int j = 4; j < dp.length; j++) {
                dp[j] = -1;
            }
            System.out.println(Pn(N));
        }

        // ex) N = 6
        // P(1) = 1, P(2) = 1, P(3) = 1
        // P(4) = P(1) + P(2) = 2
        // P(5) = P(2) + P(3) = 2
        // P(6) = P(3) + P(4) = 3
        // P(7) = P(4) + P(5) = 4

        // P(N) = P(N - 3) + P(N - 2) = ?
    }
    private static long Pn(int n) {
        if (dp[n] == -1) {
            dp[n] = Pn(n - 3) + Pn(n - 2);
        }
        return dp[n];
    }
}
