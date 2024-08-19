import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        Deque<String> deque = new ArrayDeque<>();
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < names.length; i++) {
            if (deque.size() == 5) {
                list.add(deque.poll());
                deque = new ArrayDeque<>();
            }
            deque.offer(names[i]);
        }
        
        // 남은 이름까지 넣기
        list.add(deque.poll());
        
        String[] answer = new String[list.size()];
        int index = 0;
        for (String s : list) {
            answer[index++] = s;
        }
        
        return answer;
    }
}