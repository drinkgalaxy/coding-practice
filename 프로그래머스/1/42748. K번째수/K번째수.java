import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // commands : i부터 j까지 k번째 수
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = start - 1; j < end; j++) {
                list.add(array[j]);
                Collections.sort(list);
            }
            answer[i] = list.get(k-1);
        }

        return answer;
    }
}