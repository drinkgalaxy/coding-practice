class Solution {
    public int solution(int balls, int share) {
        // 구슬이 모두 다르게 생김. balls 중에서 share개
        return (int) nCr(balls, share);
    }
    
    public static long nCr(int n, int r) {
        if (r == n) {
            return 1;
        }
        r = Math.max(r, n-r);
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        
        return result;
    }
}