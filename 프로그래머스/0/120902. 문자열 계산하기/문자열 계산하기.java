import java.util.*;

class Solution {
    public int solution(String my_string) {
        Queue<String> queue = new ArrayDeque<>();
        int answer = 0;
        for (String s : my_string.split(" ")) {
            queue.offer(s);
        }
        
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals("-")) {
                answer -= Integer.valueOf(queue.poll());
            } else if (s.equals("+")) {
                answer += Integer.valueOf(queue.poll());
            } else {
                answer += Integer.valueOf(s);
            }
        }
        
        return answer;
    }
}