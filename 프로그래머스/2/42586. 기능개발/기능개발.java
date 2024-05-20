import java.util.*;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    static int[] takeDay;
    public int solution(int[] progresses, int[] speeds) {
        takeDay = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            takeDay[i] = (100-progresses[i])/speeds[i];
            queue.add(takeDay[i]);
        }
        ArrayList<Integer> result = Comparison(queue);
        return result;
    }
    
    static public ArrayList<Integer> Comparison(Queue<Integer> queue) {
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = 1;
            int front = queue.poll();
            while (!queue.isEmpty() && queue.peek() != null && queue.peek() <= front) {
                queue.poll();
                count++;
            }
        }
        result.add(count);
    }
}