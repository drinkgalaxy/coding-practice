import java.util.*;
class Solution
{
    public int solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        
        for (String str : s.split("")) {
            if (stack.isEmpty()) {
                stack.push(str);
            } else if (stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
        
    }
    
}