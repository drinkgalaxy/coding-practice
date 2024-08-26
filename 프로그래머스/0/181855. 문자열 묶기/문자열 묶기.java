import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String s : strArr) {
            map.put(s.length(), map.getOrDefault(s.length(), 0) + 1);
        }
        
        int max = 0;
        for (Integer i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        return max;
    }
}