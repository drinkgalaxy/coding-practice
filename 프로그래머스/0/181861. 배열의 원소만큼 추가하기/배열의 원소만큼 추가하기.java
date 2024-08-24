import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                queue.add(arr[i]);
            }
        }
        
        int[] answer = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            answer[index++] = queue.poll();
        }
        return answer;
    }
}