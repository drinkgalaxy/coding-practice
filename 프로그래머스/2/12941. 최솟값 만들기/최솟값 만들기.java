import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int[] newB = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            newB[i] = B[B.length-1-i];
        }
        
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (A[i] * newB[i]);
        }

        return sum;
    }
}