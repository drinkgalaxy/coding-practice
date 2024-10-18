class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int num = 1;
        int dir = 0;
        int x = 0; 
        int y = 0;
        
        while (num <= n * n) {
            if (x < n && y < n && x >= 0 && y >= 0 && answer[y][x] == 0) {
                answer[y][x] = num++;
            } else {
                // 유효 x -> 값 되돌리기
                x -= dx[dir];
                y -= dy[dir];
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
        }
        
        return answer;
    }
}