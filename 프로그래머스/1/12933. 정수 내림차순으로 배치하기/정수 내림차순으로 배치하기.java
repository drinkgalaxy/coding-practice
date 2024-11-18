import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
    
        String[] arr = String.valueOf(n).split("");
        // 배열을 내림차순으로 정렬
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return Long.valueOf(sb.toString());
    }
}