import java.util.*;
class Solution {
    public long solution(long n) {
        
        String str = String.valueOf(n);
        
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}