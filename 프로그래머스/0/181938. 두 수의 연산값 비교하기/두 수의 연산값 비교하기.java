class Solution {
    public int solution(int a, int b) {
        int ab = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        
        if (ab >= 2*a*b) {
            return ab;
        } else {
            return 2*a*b;
        }
    }
}