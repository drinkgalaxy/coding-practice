import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int longestNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine()); // 트리의 정점의 개수
        visited = new boolean[V+1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());

                graph.get(s).add(new Node(e, w));
                graph.get(e).add(new Node(s, w));
            }
        }

        DFS(1, 0); // 임의의 첫 번째 DFS
        Arrays.fill(visited, false);
        max = 0;
        DFS(longestNode, 0); // 가장 먼 노드에서 다시 가장 먼 노드까지

        System.out.println(max);
    }

    private static void DFS(int node, int distance) {
        visited[node] = true;

        if (distance > max) {
            max = distance;
            longestNode = node;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            Node next = graph.get(node).get(i);
            if (!visited[next.end]) {
                DFS(next.end, next.weight + distance);
            }
        }
    }

    public static class Node {
        int end;
        int weight;

        public Node(int e, int w) {
            this.end = e;
            this.weight = w;
        }
    }
}