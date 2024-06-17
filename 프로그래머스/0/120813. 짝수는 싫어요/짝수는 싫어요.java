class Solution {
    public int[] solution(int n) {
        // 배열 크기 정하기
        int size = 0;
        if (n % 2 == 0) {
            size = n / 2;
        } else {
            size = (n / 2) + 1;
        }
        
        // size 크기만큼 홀수만 집어넣기
        int[] answer = new int[size];
        answer[0] = 1;
        for (int i = 1; i < size; i++) {
            answer[i] = (i * 2) + 1;
        }
        return answer;
    }
}