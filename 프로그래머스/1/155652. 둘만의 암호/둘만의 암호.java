import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        Set<Character> skipSet = new HashSet<>();
        
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for (char c : s.toCharArray()) {
            int count = 0;
            char current = c;
            
            while (count < index) {
                current++; // 다음 문자로 이동
                
                if (current > 'z') {
                    current = 'a';
                }
                
                if (!skipSet.contains(current)) {
                    count++;
                }
            }
            sb.append(current);
        }
        
        return sb.toString();
    }
}