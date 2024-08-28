import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (Integer i : arr) {
            list.add(i);
        }
        
        for (Integer i : delete_list) {
            list.remove(i);
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}