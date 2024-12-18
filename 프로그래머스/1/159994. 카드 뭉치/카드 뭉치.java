import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        
        for (String s : cards1) {
            q1.offer(s);
        }
        
        for (String s : cards2) {
            q2.offer(s);
        }
        
        for (int i = 0; i < goal.length; i++) {
            if (!q1.isEmpty() && q1.peek().equals(goal[i])) {
                q1.poll();
                continue;
            } 
            else if (!q2.isEmpty() && q2.peek().equals(goal[i])) {
                q2.poll();
                continue;
            } 
            else {
                answer = "No";
            }
        }
        return answer;
    }
}
