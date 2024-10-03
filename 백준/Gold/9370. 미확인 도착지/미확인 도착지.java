import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static final int INF = Integer.MAX_VALUE; // 엄청 큰 값 지정
    static ArrayList<ArrayList<Node>> graph;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 교차로 개수 (정점 개수)
            m = Integer.parseInt(st.nextToken()); // 도로 개수 (간선 개수)
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보의 개수

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken()); // 교차로 시작
            int h = Integer.parseInt(st.nextToken()); // 교차로 끝

            // 그래프 초기화
            graph = new ArrayList<>(); // 테스트 케이스마다 새롭게 그래프 초기화
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) { // 그래프 저장
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()); // 시작 노드
                int b = Integer.parseInt(st.nextToken()); // 끝 노드
                int d = Integer.parseInt(st.nextToken()); // 가중치

                // 양방향 저장
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            // 목적지 후보 저장
            int[] result = new int[t];
            for (int j = 0; j < t; j++) {
                result[j] = Integer.parseInt(br.readLine()); // 목적지 후보
            }

            for (int r : result) {
                int res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, r);
                int res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, r);
                int res3 = dijkstra(s, r);
                if (Math.min(res1, res2) == res3) {
                    queue.add(r);
                }
            }

            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0; // 시작노드로 가기 위한 최단 경로는 0

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowNode = now.end;
            if (!visited[nowNode]) {
                visited[nowNode] = true;
                for (int i = 0; i < graph.get(nowNode).size(); i++) {
                    Node next = graph.get(nowNode).get(i);
                    int nextNode = next.end;
                    int nextWeight = next.weight;
                    if (dist[nextNode] > dist[nowNode] + nextWeight) {
                        dist[nextNode] = dist[nowNode] + nextWeight;
                        queue.offer(new Node(nextNode, dist[nextNode]));
                    }
                }
            }
        }
        return dist[end];
    }

    public static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }
}