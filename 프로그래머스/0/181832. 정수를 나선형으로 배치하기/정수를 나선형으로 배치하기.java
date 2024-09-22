class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        // 오른쪽, 아래, 왼쪽, 위 이동
        int[] dx = {1, 0, -1, 0}; 
        int[] dy = {0, 1, 0, -1};
        int dir = 0; // 현재 위치
        int x = 0;
        int y = 0;
        
        while (num <= n * n) {
            // 유효한 값이면 진행
            if (x >= 0 && x < n && y >= 0 && y < n && answer[y][x] == 0) {
                answer[y][x] = num++;
            } else {
                // 유효하지 않은 값이면 취소 후 다음 단계
                x -= dx[dir];
                y -= dy[dir];
                dir = (dir + 1) % 4;
            }
            // 다음위치로 이동 
            x += dx[dir];
            y += dy[dir];
        }
        
        return answer;
    }
}