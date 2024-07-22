import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int[] line : lines) {
            for (int i = line[0]; i < line[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        for (int count : map.values()) {
            if (count > 1) {
                answer++;
            }
        }
    
        return answer;
    }
}