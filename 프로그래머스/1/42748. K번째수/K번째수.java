import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            
            int[] arr = new int[j-i+1];
            int idx = 0;
            for (int a = i-1; a <= j-1; a++) {
                arr[idx++] = array[a];
            }
            
            Arrays.sort(arr);
            
            answer[c] = arr[k-1];
        }
        return answer;
    }
}