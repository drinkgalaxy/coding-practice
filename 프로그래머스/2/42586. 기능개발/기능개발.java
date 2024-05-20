import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static int[] takeDay;
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        takeDay = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                queue.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        return Comparison(queue);
    }
    
    static public ArrayList<Integer> Comparison(Queue<Integer> queue) {
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int front = queue.poll();
            int count = 1;
            if (queue.peek() != null && queue.peek() <= front) {
                while (queue.peek() != null && queue.peek() <= front) {
                    queue.poll();
                    count++;
                }
            } else {
                result.add(count);
                continue;
            }
            result.add(count);
        }
        return result;
    }
}