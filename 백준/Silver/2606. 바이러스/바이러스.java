import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        visited = new boolean[N+1];

        // 초기화
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 1번이랑 연결되어 있는 것만 출력
        // 연결되어 있는 상태인지 어떻게 알지?

        for (int i = 0; i < graph.get(1).size(); i++) {
            dfs(graph.get(1).get(i));
        }

        System.out.println(count - graph.get(1).size());
    }

    private static void dfs(Integer node) {
        count++;
        visited[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            int nextNode = graph.get(node).get(i);
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}

