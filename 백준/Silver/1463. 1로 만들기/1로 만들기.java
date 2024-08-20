import java.io.*;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        dp[0] = dp[1] = 0;

        System.out.println(make(N));
    }

    public static int make(int n) {

        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(make(n / 3), Math.min(make(n / 2), make(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(make(n / 3), make(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(make(n / 2), make(n - 1)) + 1;
            } else {
                dp[n] = make(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
