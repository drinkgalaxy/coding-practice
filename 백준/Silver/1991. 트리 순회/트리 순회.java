import java.io.*;


public class Main {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int node = temp[0].charAt(0) - 'A'; // index 변환을 위해 A 빼서 0 으로 바꿔주기
            int left = temp[1].charAt(0);
            int right = temp[2].charAt(0);

            if (left == '.') { // 자식 노드가 없으면(.이면) 대신 -1 저장하기
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A'; // 있으면 index 변환 저장
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
        System.out.println();
    }

    private static void preOrder(int i) {
        if (i == -1) {
            return;
        }
        System.out.print((char) (i + 'A')); // 현재 노드 출력
        preOrder(tree[i][0]); // 왼쪽 탐색
        preOrder(tree[i][1]); // 오른쪽 탐색
    }

    private static void inOrder(int i) {
        if (i == -1) {
            return;
        }
        inOrder(tree[i][0]);
        System.out.print((char) (i + 'A'));
        inOrder(tree[i][1]);
    }

    private static void postOrder(int i) {
        if (i == -1) {
            return;
        }
        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        System.out.print((char) (i + 'A'));
    }
}