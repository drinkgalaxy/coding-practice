import java.util.*;
class Solution {
    public long solution(long n) {
        
        for (long i = 1; i <= (long) Math.sqrt(n); i++) {
            if ((long) Math.pow(i, 2) == n) {
                return (long) Math.pow(i+1, 2);
            }
        }
        return -1;
    }
}