class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
    
        int fs = intervals[0][0];
        int fe = intervals[0][1];
        int ss = intervals[1][0];
        int se = intervals[1][1];

        int[] answer = new int[(fe - fs + 1) + (se - ss + 1)];
        int index = 0;
        for (int i = fs; i <= fe; i++) {
            answer[index] = arr[i];
            index++;
        }
        for (int i = ss; i <= se; i++) {
            answer[index] = arr[i];
            index++;
        }
        
        return answer;
    }
}