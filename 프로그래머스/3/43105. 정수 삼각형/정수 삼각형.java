class Solution {
    static Integer[][] dp;
    static int n;
    public int solution(int[][] triangle) {
        n = triangle.length;
        dp = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        return getMax(triangle, 0, 0);
    }
    
    public int getMax(int[][] triangle, int depth, int index) {
        if (depth == n-1) {
            return dp[depth][index];
        }
        
        if (dp[depth][index] == null) {
            dp[depth][index] = 
                Math.max(getMax(triangle, depth+1, index),getMax(triangle, depth+1, index+1))
                + triangle[depth][index]; 
        }
        
        return dp[depth][index];
    }
}