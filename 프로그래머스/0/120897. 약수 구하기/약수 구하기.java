import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        
        int index = 0;
        int[] answer = new int[list.size()];
        for (Integer i : list) {
            answer[index] = i;
            index++;
        }
        return answer;
    }
}