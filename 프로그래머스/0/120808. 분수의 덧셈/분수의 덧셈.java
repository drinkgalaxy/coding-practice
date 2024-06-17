class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
    
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        // 기약분수로 만들어야함 - 유클리드 호제법을 사용할 수 있음
        int gcd = gcd(numer, denom);
        
        int[] answer = {numer / gcd, denom / gcd};
        return answer;
    }
    
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}