import java.util.*;
class Solution {
    public int[] solution(int n) {
        // 하, 우, 상좌
        // 시작을 0, 0
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        
        int[][] arr = new int[n][n];
        int num = 1;
        int x = 0; 
        int y = 0;
        int dir = 0;
        
        while (true) {
            arr[y][x] = num++;
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;
            
            if (nx == n || ny == n || arr[ny][nx] != 0) {
                dir = (dir + 1) % 3;
                nx = dx[dir] + x;
                ny = dy[dir] + y;
                
                if (nx == n || ny == n || arr[ny][nx] != 0) {
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
        int idx = 0;
        for (Integer i : list) {
            answer[idx++] = i;
        }
        return answer;
    }
}