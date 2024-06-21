import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        // 두 수를 합친 값이 큰 순서대로 (내림차순)
        // o1 : 10, o2 : 2 이면 102와 210 중 뭐가 더 큰지 비교
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (str[0].equals("0")) {
            return "0";
        }
        
        for (String num : str) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}