import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] result = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전체 종이의 한 변의 길이
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quad(arr, 0, 0, N);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static void quad(int[][] arr, int x, int y, int size) {
        if (IsPossible(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 0) {
                result[0]++;
            } else {
                result[1]++;
            }
            return;
        }
        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x + size / 2, y + size / 2, size / 2);
    }

    static boolean IsPossible(int[][] arr, int x, int y, int size, int val) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}