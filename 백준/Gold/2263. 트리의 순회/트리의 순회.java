import java.io.*;
import java.util.*;

public class Main {
    static int[] inOrder, postOrder;
    static HashMap<Integer, Integer> inOrderIndexMap;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIndexMap = new HashMap<>();

        // inOrder
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            // 인오더 값의 위치 저장
            inOrderIndexMap.put(inOrder[i], i);
        }

        // postOrder
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, n-1, 0, n-1);
        // inOrder 시작 끝, postOrder 시작 끝

        System.out.println(sb);
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder[postEnd];
        sb.append(root).append(" ");

        // 인오더에서 루트의 위치 찾기
        int rootIndex = inOrderIndexMap.get(root);
        // 왼쪽 서브트리 크기 구하기
        int leftSubtreeSize = rootIndex - inStart;

        // 왼쪽 서브트리와 오른쪽 서브트리 재귀적으로 처리
        getPreOrder(inStart, rootIndex-1, postStart, postStart+leftSubtreeSize-1); // 왼쪽 서브트리
        getPreOrder(rootIndex+1, inEnd, postStart+leftSubtreeSize, postEnd-1); // 오른쪽 서브트리
    }
}