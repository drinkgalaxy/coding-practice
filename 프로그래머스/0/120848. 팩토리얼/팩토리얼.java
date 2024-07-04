class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int number = getFactorial(i);
            if (number > n) {
                break;
            }
            answer = i;
        }
        return answer;
        
    }
    
    public int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}