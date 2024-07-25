import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int average = total / num;
        int start = average - (num - 1) / 2;
        
        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }
        
        return answer;
    }
}
