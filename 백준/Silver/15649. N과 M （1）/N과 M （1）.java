import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0);
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth) {

        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열 출력
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            // 만약 해당 노드를 방문하지 않았다면?
            if (!visit[i]) {
                visit[i] = true; // 해당 노드 방문 상태로 변경
                arr[depth] = i + 1; // 해당 깊이 + 1를 저장
                dfs(N, M, depth + 1); // 다음 자식 노드 방문을 위해 depth++ 하며 재귀호출

                // 자식 노드를 모두 방문하고 전 재귀상태로 돌아가기
                visit[i] = false;
            }
        }
    }

}