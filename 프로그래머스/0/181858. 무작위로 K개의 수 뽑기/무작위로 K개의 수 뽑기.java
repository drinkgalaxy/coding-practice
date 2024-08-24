import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (Integer i : arr) {
            if (!list.contains(i) && list.size() < k) {
                list.add(i);
            }
        } 
        
        while (list.size() < k) {
            list.add(-1);
        }
        
        int[] answer = new int[k];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}