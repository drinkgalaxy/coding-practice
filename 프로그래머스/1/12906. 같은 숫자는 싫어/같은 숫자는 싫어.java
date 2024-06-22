import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 선입선출구조 -> Queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1) {
                if (arr[i] != arr[i+1]) {
                    queue.offer(arr[i]);
                }
            } else {
                queue.offer(arr[i]);
            }
        }
        
        int size = queue.size();
        int[] answer = new int[size];
        int index = 0;
        while (!queue.isEmpty()) {
            answer[index] = queue.poll();
            index++;
        }
        
        return answer;
    }
}