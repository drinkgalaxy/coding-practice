import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(i);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(numbers[i])) {
                list.remove(Integer.valueOf(numbers[i]));
            }
        }
        
        int answer = 0;
        for (Integer i : list) {
            answer += i;
        }
        
        return answer;
    }
}