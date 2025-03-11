class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dx = {1, 0, -1, 0}; // 우하좌상
        int[] dy = {0, 1, 0, -1};
        
        int num = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        
        while (num <= n * n) {
            if (x < n && x >= 0 && y < n && y >= 0 && answer[y][x] == 0) {
                answer[y][x] = num++;
            } else {
                x -= dx[d];
                y -= dy[d];
                d = (d + 1) % 4;
            }
            x += dx[d];
            y += dy[d];
        }
        return answer;
    }
}