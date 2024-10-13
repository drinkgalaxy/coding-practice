import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int firstNode = 0;
    static int secondNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }

        DFS(1, 0); // 임의의 노드부터 시작
        Arrays.fill(visited, false);
        max = 0;

        DFS(firstNode, 0); // 가장 긴 노드 시작
        Arrays.fill(visited, false);
        visited[firstNode] = true;

        DFS(secondNode, 0); // 두번째 긴 노드 시작

        System.out.println(max);
    }

    private static void DFS(int node, int distance) {
        visited[node] = true;

        if (distance > max) {
            max = distance;
            firstNode = node;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            Node next = graph.get(node).get(i);
            if (!visited[next.end]) {
                DFS(next.end, distance + next.weight);
            }
        }
    }

    public static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}