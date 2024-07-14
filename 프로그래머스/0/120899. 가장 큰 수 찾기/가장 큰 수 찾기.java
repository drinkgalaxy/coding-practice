class Solution {
    public int[] solution(int[] array) {
        int max = 0;
        int maxIndex = 0;
        int[] answer = {max, maxIndex};
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        answer[0] = max;
        answer[1] = maxIndex;
        
        return answer;
    }
}