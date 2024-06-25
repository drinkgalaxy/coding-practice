import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : num_list) {
            list.add(i);
        }
        
        Collections.reverse(list);
        
        int index = 0;
        for (Integer i : list) {
            num_list[index] = i;
            index++;
        }
        return num_list;
    }
}