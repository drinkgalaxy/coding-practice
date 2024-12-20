class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        // 공식 x^2 + y^2 <= d^2
        // y <= d^2 - x^2 의 제곱근
        for (int x = 0; x <= d; x += k) {
            double y = Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += (long) (y / k) + 1;
        }
        return answer;
    }
}