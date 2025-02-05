import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int[][] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    tree = new int[26][2];

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split(" ");
      int node = temp[0].charAt(0) - 'A';
      int left = temp[1].charAt(0);
      int right = temp[2].charAt(0);

      if (left == '.') {
        tree[node][0] = -1;
      } else {
        tree[node][0] = left - 'A';
      }

      if (right == '.') {
        tree[node][1] = -1;
      } else {
        tree[node][1] = right - 'A';
      }
    }

    preOrder(0);
    System.out.println();
    inOrder(0);
    System.out.println();
    postOrder(0);
  }

  private static void preOrder(int n) {
    if (n == -1) {
      return;
    }
    System.out.print((char) (n + 'A')); // 현재 노드 출력
    preOrder(tree[n][0]); // 왼쪽 탐색
    preOrder(tree[n][1]); // 오른쪽 탐색
  }

  private static void inOrder(int n) {
    if (n == -1) {
      return;
    }
    inOrder(tree[n][0]);
    System.out.print((char) (n + 'A'));
    inOrder(tree[n][1]);
  }

  private static void postOrder(int n) {
    if (n == -1) {
      return;
    }
    postOrder(tree[n][0]);
    postOrder(tree[n][1]);
    System.out.print((char) (n + 'A'));
  }
}
 