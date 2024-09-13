import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 초기화
        visited = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 데이터 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < graph.size(); i++) { // 내림차순 방문
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        count = 1;
        dfs(R);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = count;
        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);
            if (visited[nextNode] == 0) {
                count++;
                dfs(nextNode);
            }
        }
    }
}
