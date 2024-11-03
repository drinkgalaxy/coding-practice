import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] paper;
    static int m1, z, p1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quad(0, 0, N);

        System.out.println(m1);
        System.out.println(z);
        System.out.println(p1);

    }

    static void quad(int x, int y, int size) {
        if (IsPossible(x, y, size, paper[x][y])) {
            if (paper[x][y] == -1) {
                m1++;
            } else if (paper[x][y] == 0) {
                z++;
            } else {
                p1++;
            }
            return;
        }

        int newSize = size / 3;

        // 9개의 사분면을 전부 해줘야 됨.
        // 위에서부터 col 쪽으로 순서대로 호출한 것.
        quad(x, y, newSize);
        quad(x, y + newSize, newSize);
        quad(x, y + 2 * newSize, newSize);

        quad(x + newSize, y, newSize);
        quad(x + newSize, y + newSize, newSize);
        quad(x + newSize, y + 2 * newSize, newSize);

        quad(x + 2 * newSize, y, newSize);
        quad(x + 2 * newSize, y + newSize, newSize);
        quad(x + 2 * newSize, y + 2 * newSize, newSize);
    }

    static boolean IsPossible(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}