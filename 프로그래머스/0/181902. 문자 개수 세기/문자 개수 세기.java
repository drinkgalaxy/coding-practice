import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String[] voca = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
                        "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
                        "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", 
                        "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", 
                        "s", "t", "u", "v", "w", "x", "y", "z"};

        Map<String, Integer> map = new HashMap<>();
        for (String s : voca) {
            map.put(s, map.getOrDefault(s, 0));
        }
        
        for (String s : my_string.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        int index = 0;
        int[] answer = new int[map.size()];
        for (Integer i : map.values()) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}