import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        
        // 지뢰 주변 위치값 지정
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        
        // 지뢰 값 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int[] temp = {i, j};
                    list.add(temp);
                }
            }
        }
        
        // 지뢰 주변 위치를 1로 바꿔주기
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            for (int j = 0; j < 8; j++) {
                if (dx[j] + x >= 0 && dy[j] + y >= 0 && dx[j] + x <= board.length-1 && dy[j] + y <= board.length-1) {
                    board[dx[j] + x][dy[j] + y] = 1;
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
	        for(int j=0; j<board[0].length; j++){
		        if(board[i][j] == 0){
			        answer++;
		        }
	        }
        }
        
        return answer;
    }
}