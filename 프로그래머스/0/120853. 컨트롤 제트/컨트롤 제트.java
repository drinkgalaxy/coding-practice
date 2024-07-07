import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        for (String str : s.split(" ")) {
            if (str.equals("Z")) {
                stack.poll();
            } else {
                stack.push(str);
            }   
        }
        
        int answer = 0;
        for (String str : stack) {
            answer += Integer.valueOf(str);
        }
        return answer;
    }
}