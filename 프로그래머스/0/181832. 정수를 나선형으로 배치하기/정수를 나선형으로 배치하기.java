class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        // 방향을 바꾸는 dx, dy 배열
        // 순서대로 오른쪽 -> 아래 -> 왼쪽 -> 위
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int dir = 0; // 현재 방향
        int x = 0;
        int y = 0;
        
        while (num <= n * n) {
            // 현재 위치가 유효하고 0 이면 숫자를 채운다.
            // 시계 방향으로 채우기 위해 answer[y][x]
            if (x >= 0 && x < n && y >= 0 && y < n && answer[y][x] == 0) {
                answer[y][x] = num++;
            } else {
                // 유효하지 않은 위치면 방향을 되돌리고 방향을 변경함.
                x -= dx[dir];
                y -= dy[dir];
                dir = (dir + 1) % 4;
            }
            // 다음 위치로 이동
            x += dx[dir];
            y += dy[dir];
        }
        
        return answer;
    }
}