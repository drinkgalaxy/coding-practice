import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    deque.offer(arr[i]);
                } 
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    deque.pollLast();
                }
            }
        }
        
        int[] answer = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            answer[index++] = deque.poll();
        }
        
        return answer;
    }
}