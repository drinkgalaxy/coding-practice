import java.util.*;
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long newx = (long) x;
        int size = 0;
        long add = newx;
        while (size < n) {
            answer[size++] = newx;
            newx += add;
        }
        
        return answer;
    }
}