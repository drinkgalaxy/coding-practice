class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }
        
        int answer = 0;
        long longNum = Long.valueOf(num);
        while (longNum > 1) {
            if (answer == 500) {
                return -1;
            }
            
            if (longNum % 2 == 0) {
                answer++;
                longNum /= 2;
            } else {
                answer++;
                longNum = longNum * 3 + 1;
            }
        }
        return answer;
    }
}