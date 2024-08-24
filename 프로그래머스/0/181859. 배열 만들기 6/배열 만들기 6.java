import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        
        int i = 0;
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.offer(arr[i]);
                i++;
            } else {
                if (stk.peekLast() == arr[i]) {
                    stk.pollLast();
                    i++;
                } else {
                    stk.offer(arr[i]);
                    i++;
                }
            }
        }
        
        if (stk.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[stk.size()];
        int index = 0;
        while (!stk.isEmpty()) {
            answer[index++] = stk.poll();
        }
        
        return answer;
    }
}