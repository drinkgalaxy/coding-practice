import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        
        // 2의 인덱스 저장
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                deque.offer(i);
            }
        }
        
        // // 2인 인덱스 자르기
        if (deque.size() > 1) {
            int s = deque.pollFirst();
            int e = deque.pollLast();
            int index = 0;
            answer = new int[e - s + 1];
            for (int i = s; i <= e; i++) {
                answer[index++] = arr[i];
            }
        } else if (deque.size() == 1) {
            answer = new int[1];
            answer[0] = 2;
        } else {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

}