class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
    
        int[] dx = {1, 0, -1, 0}; // 시계방향 : 우, 하, 좌, 상
        int[] dy = {0, 1, 0, -1};
        
        int num = 1;
        int dir = 0;
        int x = 0;
        int y = 0;
        
        while (num <= n * n) {
            if (x >= 0 && x < n && y >= 0 && y < n && answer[y][x] == 0) {
                answer[y][x] = num++;
            } else {
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