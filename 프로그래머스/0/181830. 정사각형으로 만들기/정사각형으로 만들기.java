import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        // 배열이 생성되면 어차피 0으로 초기화된다.
        // row, col에 arr 값 크기 저장. 그리고 row, col 을 비교하면서 ++
        // 그 크기만큼 새 answer 배열을 생성한다음에 arr값만 넣어주기.
        int row = arr.length;
        int col = arr[0].length;
        
        while (row != col) {
            if (row < col) {
                row++;
            } else {
                col++;
            }
        }
        
        int[][] answer = new int[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        return answer;
    }
}