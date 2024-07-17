class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (Integer i : array) {
            if (i == n) {
                answer++;
            }
        }
        return answer;
    }
}