import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int min = sides[0];
        int max = sides[1];
        
        // 가장 큰 변은 b
        for (int i = max - min + 1; i <= max; i++) {
            answer++;
        }
        
        // 가장 큰 변은 c
        for (int i = max + 1; i < min + max; i++) {
            answer++;
        }
        
        return answer;
    }
}