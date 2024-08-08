import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String str : intStrs) {
            String sub = str.substring(s, s+l);
            if (Integer.valueOf(sub) > k) {
                list.add(Integer.valueOf(sub));
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}