class Solution {
    static int answer;
    static int[] numbers;
    static int target;
    public int solution(int[] numbers, int target) {
        answer = 0;
        numbers = numbers;
        target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}