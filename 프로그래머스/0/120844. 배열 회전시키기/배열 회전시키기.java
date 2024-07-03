import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer i : numbers) {
            deque.offer(i);
        }

        if (direction.equals("right")) {
            int left = deque.pollLast();
            deque.offerFirst(left);
        } else {
            int right = deque.pollFirst();
            deque.offerLast(right);
        }
        int index = 0;
        for (Integer i : deque) {
            answer[index] = i;
            index++;
        }

        return answer;
    }
}