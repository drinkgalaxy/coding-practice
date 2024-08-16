import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (Integer i : arr) {
            list.add(i);
        }
        
        int s = list.size();
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                for (int j = s - 1; j > query[i]; j--) {
                    list.remove(j);
                    s = list.size();
                }
            } else {
                for (int j = 0; j < query[i]; j++) {
                    list.remove(0);
                    s = list.size();
                }
            }
        }
        
        int[] answer = new int[s];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}