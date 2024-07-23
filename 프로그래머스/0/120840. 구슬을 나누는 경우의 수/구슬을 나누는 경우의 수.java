class Solution {
    public int solution(int balls, int share) {
        return (int) nCr(balls, share);
    }
    
    public long nCr(int n, int r) {
        if (n == r) {
            return 1;
        }
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        
        return result;
    }
}