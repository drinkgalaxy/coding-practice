import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {

        // 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열 출력
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

}