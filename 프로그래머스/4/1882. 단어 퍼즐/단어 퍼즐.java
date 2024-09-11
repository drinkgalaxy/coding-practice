class Solution {
    public int solution(String[] strs, String t) {
        int answer = 0;
        
        int[] dp = new int[t.length()+1];
        
        // 초기화
        for (int i = 1; i <= t.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for (int i = 0; i < t.length(); i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (String str : strs) {
                    if (t.startsWith(str, i)) {
                        int nextIndex = i + str.length();
                        dp[nextIndex] = Math.min(dp[nextIndex], dp[i] + 1);
                    }
                }
            }
        }

        return (dp[t.length()] == Integer.MAX_VALUE) ? -1 : dp[t.length()];
    }
}