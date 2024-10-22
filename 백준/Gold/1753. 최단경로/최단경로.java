import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Node> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        distance = new int[V+1];
        visited = new boolean[V+1];

        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        // 그래프 값 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 최단 경로 값 초기화
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘 수행
        queue.offer(new Node(K, 0)); // 시작점은 K
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int current = n.e;
            if (!visited[current]) {
                visited[current] = true;
                for (int i = 0; i < graph.get(current).size(); i++) {
                    Node tmp = graph.get(current).get(i);
                    int nextNode = tmp.e;
                    int nextWeight = tmp.w;
                    if (distance[nextNode] > distance[current] + nextWeight) {
                        distance[nextNode] = distance[current] + nextWeight;

                        queue.add(new Node(nextNode, distance[nextNode]));
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w - node.w;
        }
    }
}