import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        Set<Character> set = new HashSet<>();
        for (char c : skip.toCharArray()) {
            set.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            int count = 0;
            char current = c;
            while (count < index) {
                current++;
                
                if (current > 'z') {
                    current = 'a';
                }
                
                if (!set.contains(current)) {
                    count++;
                }
            }
            result.append(current);
        }
        
        return result.toString();
    }
}