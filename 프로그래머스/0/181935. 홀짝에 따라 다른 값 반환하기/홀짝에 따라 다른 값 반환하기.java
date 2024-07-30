class Solution {
    public int solution(int n) {
        int odd = 0;
        int even = 0;
        
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i = i + 2) {
                even += i * i;
            }
            return even;
        } else {
            for (int i = 1; i <= n; i = i + 2) {
                odd += i;
            }
            return odd;
        }
    }
}