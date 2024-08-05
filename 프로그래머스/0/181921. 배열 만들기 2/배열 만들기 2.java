import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String number = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < number.length(); j++) {
                if (number.charAt(j) != '0' && number.charAt(j) != '5') {
                    check = false;
                }
            }
            if (check) {
                list.add(Integer.valueOf(number));
            }
        }
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        int size = list.size();
        int[] answer = new int[size];
        int index = 0;
        for (Integer i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}