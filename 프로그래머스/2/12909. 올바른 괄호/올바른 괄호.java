import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<String> stack = new ArrayDeque<>();
        for (String str : s.split("")) {
            if (str.equals("(")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}