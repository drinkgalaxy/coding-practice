import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        
        int[][] arr = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0; 
        int d = 0;
        
        while (true) {
            arr[y][x] = v++; // 데이터 저장
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx == n || ny == n || arr[ny][nx] != 0) { // 방향 전환 할 시기
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                
                if (nx == n || ny == n || arr[ny][nx] != 0) { // 이땐 아예 끝
                    break; 
                }
            }
            x = nx;
            y = ny;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    list.add(arr[i][j]);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for (int i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}