class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String a_ = String.valueOf(a);
        String b_ = String.valueOf(b);

        
        return Math.max(Integer.valueOf(a_+b_), 2 * a * b);
    }
}