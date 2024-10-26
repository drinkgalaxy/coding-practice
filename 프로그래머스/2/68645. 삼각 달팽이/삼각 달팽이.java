import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int[] dx = {0, 1, -1}; // 아래, 오른쪽, 대각선위왼쪽
        int[] dy = {1, 0, -1};
        
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;
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
        int index = 0;
        for (int i : list) {
            answer[index++] = i;
        }
        
        return answer;
    }
}