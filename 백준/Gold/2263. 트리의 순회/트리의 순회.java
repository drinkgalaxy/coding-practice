import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrder, postOrder;
    static HashMap<Integer, Integer> inOrderIndexMap; // 인오더에서 값의 인덱스를 저장하는 맵
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 트리의 정점 개수
        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIndexMap = new HashMap<>();

        // 인오더 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndexMap.put(inOrder[i], i); // 인오더 값의 위치 저장
        }

        // 포스트오더 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, n - 1, 0, n - 1);

        // 결과 출력
        System.out.println(sb.toString());
    }

    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return; // 더 이상 서브트리가 없을 때
        }

        int root = postOrder[postEnd];
        sb.append(root).append(" ");

        // 인오더에서 루트의 위치 찾기
        int rootIndex = inOrderIndexMap.get(root);
        // 왼쪽 서브트리 크기 구하기
        int leftSubtreeSize = rootIndex - inStart;

        // 왼쪽 서브트리와 오른쪽 서브트리 재귀적으로 처리
        getPreOrder(inStart, rootIndex - 1, postStart, postStart + leftSubtreeSize - 1); // 왼쪽 서브트리
        getPreOrder(rootIndex + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1); // 오른쪽 서브트리
    }
}
