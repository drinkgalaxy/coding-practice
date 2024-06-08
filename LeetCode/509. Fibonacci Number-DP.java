class Solution {
    public int fib(int n) {
        // 1. n이 0일 경우 0 리턴
        if (n == 0 || n == 1) {
            return n;
        }
        // 2. 중복 호출을 막기 위해 배열 생성
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
