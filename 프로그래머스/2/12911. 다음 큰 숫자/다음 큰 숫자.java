class Solution {
    public int solution(int n) {
        int next = n;
        while (true) {
            next++;
            if (Integer.bitCount(n) == Integer.bitCount(next)) {
                return next;
            }
        }
    }
}