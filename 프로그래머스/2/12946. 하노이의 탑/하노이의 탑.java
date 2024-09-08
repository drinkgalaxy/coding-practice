import java.util.*;
class Solution {
    static ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {

        Hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
    public void Hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        // n-1 -> mid
        Hanoi(n-1, start, end, mid);
        
        // n -> end
        list.add(new int[]{start, end});
        
        // n-1 -> end
        Hanoi(n-1, mid, start, end);
    }
}