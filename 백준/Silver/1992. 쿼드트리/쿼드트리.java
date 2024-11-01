import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 영상의 크기
        arr = new char[N][N];
        answer = new int[2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        quad(arr, 0, 0, N);

        System.out.println(sb);
    }

    static void quad(char[][] arr, int x, int y, int size) {
        if (IsPossible(arr, x, y, size, arr[x][y])) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append('(');
        quad(arr, x, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x + size / 2, y + size / 2, size / 2);
        sb.append(')');
    }

    static boolean IsPossible(char[][] arr, int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}