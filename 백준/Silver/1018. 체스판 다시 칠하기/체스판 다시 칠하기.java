
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 체스판에 데이터 저장하기
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        // N * M 체스판 탐색
        int N_row = N - 7;
        int M_row = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_row; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    // 탐색하는 함수 구현
    private static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }
                TF = (!TF);
            }
            TF = (!TF);
        }

        count = Math.min(count, 64 - count);
        min = Math.min(count, min);
    }
}