import java.util.*;

class Solution {
    public String solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1) {
                list.add(str);
            }
        }
        Collections.sort(list);
        
        String answer = "";
        for (String str : list) {
            answer += str;
        }
        
        return answer;
    }
}