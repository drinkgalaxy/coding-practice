class Solution {
    public int solution(int M, int N) {
        if (M == 0 || N == 0) {
            return 0;
        }
        
        return (M - 1) + (M * (N - 1));
    }
}