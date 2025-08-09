import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // 중복 문자가 있으면 이동
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

           set.add(c);
           max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
