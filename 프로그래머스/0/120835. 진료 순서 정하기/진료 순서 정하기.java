class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 1; i <= emergency.length; i++) {
            // 최댓값 찾은 후 maxIndex 찾기
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < emergency.length; j++) {
                if (max <= emergency[j]) {
                    max = emergency[j];
                    maxIndex = j;
                }
            }
            // maxIndex의 값 0으로 변경
            emergency[maxIndex] = 0;
            answer[maxIndex] = i;
        }
        return answer; 
    }

}