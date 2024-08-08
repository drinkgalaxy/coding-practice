import java.io.*;

public class Main {
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(Tile(N));

        // N = 1 일 때는 1
        // N = 2 일 때는 11, 00

        // N = 3 일 때는 111, 100, 001
        // N = 4 일 때는 1111, 1100, 1001, 0011, 0000
        // f(N) = f(N-1) + f(N-2);
    }

    private static int Tile(int n) {
        if (dp[n] == -1) {
            dp[n] = (Tile(n - 1) + Tile(n - 2)) % 15746;
        }
        return dp[n];
    }
}
