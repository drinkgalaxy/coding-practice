import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        list.remove(Integer.valueOf(min));
        
        if (list.size() < 1) {
            return new int[]{-1};
        }
        
        int idx = 0;
        int[] answer = new int[list.size()];
        for (int i : list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}