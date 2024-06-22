import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pLong = Long.valueOf(p);
        
        for (int i = 0; i <= t.length() - pLength; i++) {
            long tSub = Long.valueOf(t.substring(i, i+pLength));
            if (tSub <= pLong) {
                answer++;
            }
        }
        
        return answer;
    }
}