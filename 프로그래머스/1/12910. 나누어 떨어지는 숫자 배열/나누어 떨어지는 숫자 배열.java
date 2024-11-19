import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                if (!list.contains(i)) {
                    list.add(i);
                }
            }
        }
        
        if (list.size() < 1) {
            return new int[]{-1};
        }
        
        int idx = 0;
        int[] answer = new int[list.size()];
        for (Integer i : list) {
            answer[idx++] = i;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}