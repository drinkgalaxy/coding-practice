import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        answer = new int[N+1];

        for (int i = 0; i < tree.length; i++) { // 인접 리스트 초기화
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) { // 인접 리스트 데이터 저장 (1 ~ N-1)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int node) {
        visited[node] = true;
        for (int i : tree[node]) { // 인접 리스트를 순회하는 동안
            if (!visited[i]) {
                answer[i] = node;
                DFS(i);
            }
        }
    }
}