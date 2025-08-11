import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        // amount 를 맞추는 최소 동전의 수
        int max = amount + 1;
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] >= max ? -1 : dp[amount];
    }
}
