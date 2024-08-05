import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        
        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
            } else {
                if (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.push(arr[i]);
                    i++;
                } else {
                    stack.pop();
                }
            }
        }
        
        int[] stk = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            stk[j] = stack.pop();
        }
        return stk;
    }
}