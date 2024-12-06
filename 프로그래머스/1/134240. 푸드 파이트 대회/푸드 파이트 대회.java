import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int i = food.length-1; i >= 0; i--) {
            while (food[i] > 1) {
                deque.offerFirst(i);
                deque.offerLast(i);
                food[i] -= 2;
            }
        }
        
        for (Integer i : deque) {
            sb.append(i);
        }
        
        return sb.toString();
    }
}