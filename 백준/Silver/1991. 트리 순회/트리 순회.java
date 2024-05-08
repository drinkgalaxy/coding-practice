import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int parentNode = temp[0].charAt(0)-'A';

            char leftNode = temp[1].charAt(0);
            char rightNode = temp[2].charAt(0);

            if (leftNode == '.') {
                tree[parentNode][0] = -1;
            } else {
                tree[parentNode][0] = leftNode - 'A';
            }

            if (rightNode == '.') {
                tree[parentNode][1] = -1;
            } else {
                tree[parentNode][1] = rightNode - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int n) {
        if (n == -1) {
            return;
        }
        System.out.print((char) (n + 'A'));
        preOrder(tree[n][0]);
        preOrder(tree[n][1]);
    }

    public static void inOrder(int n) {
        if (n == -1) {
            return;
        }
        inOrder(tree[n][0]);
        System.out.print((char) (n + 'A'));
        inOrder(tree[n][1]);
    }

    public static void postOrder(int n) {
        if (n == -1) {
            return;
        }
        postOrder(tree[n][0]);
        postOrder(tree[n][1]);
        System.out.print((char) (n + 'A'));
    }
}

