import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int fibCount = 0;
    static int fibonacciCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib(N);
        fibonacci(N);
        System.out.println(fibCount+" "+ fibonacciCount);
    }


    private static int fib(int n) {

        if (n == 1 || n == 2) {
            fibCount++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    private static int fibonacci(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibonacciCount++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
