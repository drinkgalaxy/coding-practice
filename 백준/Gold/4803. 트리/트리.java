import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int caseNumber = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean isTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 정점
            int m = Integer.parseInt(st.nextToken()); // 간선

            if (n == 0 && m == 0) {
                break;
            }
            visited = new boolean[n+1];

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    DFS(i, -1);
                    if (isTree) {
                        treeCount++;
                    }
                }
            }

            caseNumber++;

            if (treeCount < 1) {
                System.out.println("Case "+caseNumber+": No trees.");
            } else if (treeCount == 1) {
                System.out.println("Case "+caseNumber+": There is one tree.");
            } else {
                System.out.println("Case "+caseNumber+": A forest of "+treeCount+" trees.");
            }
        }
    }

    private static void DFS(int node, int parent) {
        visited[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);
            if (!visited[next]) {
                DFS(next, node);
            } else if (next != parent) {
                // 방문한 노드에 사이클이 있으면 트리가 아니다.
                isTree = false;
            }
        }
    }
}
