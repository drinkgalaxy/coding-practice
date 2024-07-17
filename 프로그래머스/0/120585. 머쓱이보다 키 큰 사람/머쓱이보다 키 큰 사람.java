class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (Integer i : array) {
            if (i > height) {
                answer++;
            }
        }
        return answer;
    }
}