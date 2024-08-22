import java.io.*;

public class Main {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수

        dp = new Integer[n+1];
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(getMax(n));

    }

    private static int getMax(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(getMax(n - 2), getMax(n - 3) + arr[n - 1]) + arr[n], getMax(n - 1));
        }

        return dp[n];
    }

}
