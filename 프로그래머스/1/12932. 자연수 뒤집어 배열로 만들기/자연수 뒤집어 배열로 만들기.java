import java.util.*;
class Solution {
    public int[] solution(long n) {
        
        Stack<Integer> stack = new Stack<>();
        
        String sn = String.valueOf(n);
        for (String s : sn.split("")) {
            stack.push(Integer.parseInt(s));
        }
        
        int[] answer = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            answer[index++] = stack.pop();
        }
        
        return answer;
    }
}