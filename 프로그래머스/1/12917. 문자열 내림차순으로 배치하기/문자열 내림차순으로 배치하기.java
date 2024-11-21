import java.util.*;
class Solution {
    public String solution(String s) {
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper.add(s.charAt(i));
            } else {
                lower.add(s.charAt(i));
            }
        }
        
        Collections.sort(upper, Collections.reverseOrder());
        Collections.sort(lower, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (char c : lower) {
            sb.append(c);
        }
        for (char c : upper) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}