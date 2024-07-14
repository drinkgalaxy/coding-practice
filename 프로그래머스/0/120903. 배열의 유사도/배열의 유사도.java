import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : map.keySet()) {
            if (map.get(s) != 1) {
                answer += 1;
            }
        }
        return answer;
    }
}