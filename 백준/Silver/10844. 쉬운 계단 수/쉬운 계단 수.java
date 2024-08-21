import java.io.*;

public class Main {
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10]; // N개의 자릿값을 표현하고, 그 자릿값은 각각 0~9의 값을 가짐

        // 첫 번째 자리수 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += dfs(N, i);
        }
        System.out.println(result % 1000000000);


    }

    public static Long dfs(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val];
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = dfs(digit - 1, 1);
            }  else if (val == 9) {
                dp[digit][val] = dfs(digit - 1, 8);
            } else {
                dp[digit][val] = dfs(digit - 1, val - 1) + dfs(digit - 1, val + 1);
            }
        }

        return dp[digit][val] % 1000000000;
    }

}
