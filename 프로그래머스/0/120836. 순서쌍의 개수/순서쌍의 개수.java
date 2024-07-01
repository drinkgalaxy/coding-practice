import java.util.*;

class Solution {
    public int solution(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int value = n / i;
                map.put(i, value);
            }
        }
        
        int answer = 0;
        for (Integer key : map.keySet()) {
            answer++;
        }
        return answer;
    }
}