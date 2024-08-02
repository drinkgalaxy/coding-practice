import java.io.*;

public class Main {

    public static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        // 스도쿠 데이터 저장
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            String[] numbers = input.split(" ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        findAnswer(0, 0);

    }

    public static void findAnswer(int row, int col) {
        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            findAnswer(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워지면 출력 후 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            // 출력 후 시스템 종료
            System.exit(0);
        }

        // 만약 해당 위치의 값이 0 이라면 1부터 9까지 중 가능한 수 탐색
        if(sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    sudoku[row][col] = i;
                    findAnswer(row, col + 1);
                }
            }
            // 탐색하다가 안되는 탐색이면 되돌아감
            sudoku[row][col] = 0;
            return;
        }

        // 0이 아니라면 다음 열 탐색
        findAnswer(row, col + 1);
    }

    static public boolean isPossible(int row, int col, int value) {
        // 가로줄에 겹치는 숫자가 있으면 false, 없으면 true
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        // 세로줄에 겹치는 숫자가 있으면 false, 없으면 true
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        // 3 x 3 안에 겹치는 숫자가 있으면 false, 없으면 true
        int set_row = (row / 3) * 3; // value 가 속한 3x3 행의 첫 위치
        int set_col = (col / 3) * 3; // value 가 속한 3x3 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}