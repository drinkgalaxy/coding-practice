import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        
        for (String ss : s.split("")) {
            answer += Integer.parseInt(ss);
        }

        return answer;
    }
}