import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int find = commands[i][2];
            ArrayList<Integer> newList = new ArrayList<>();
            for (int j = start-1; j < end; j++) {
                newList.add(array[j]);
            }
            Collections.sort(newList);
            answer[i] = newList.get(find-1);
            
        }
        return answer;
    }
}