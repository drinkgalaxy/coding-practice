class Solution {
    public int solution(int a, int b) {

        String a_ = String.valueOf(a);
        String b_ = String.valueOf(b);
        
        return Math.max(Integer.valueOf(a_ + b_), Integer.valueOf(b_ + a_));
    }
}