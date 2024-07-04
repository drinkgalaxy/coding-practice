class Solution {
    public int solution(int n) {
        int answer = 0;
        // number가 너무 커지는 걸 방지하기 위해 1부터 시작, number가 n이 커지기 전까지 진행
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