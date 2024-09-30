import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    static int[] distance; // 최단거리 배열
    static boolean[] visited; // 방문 배열
    static int N;
    static final int INF = 200000 * 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        list = new ArrayList[N+1];
        distance = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 저장
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int sol1 = 0;
        sol1 += dijkstra(1, v1);
        sol1 += dijkstra(v1, v2);
        sol1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        int sol2 = 0;
        sol2 += dijkstra(1, v2);
        sol2 += dijkstra(v2, v1);
        sol2 += dijkstra(v1, N);

        int result = (sol1 >= INF && sol2 >= INF) ? -1 : Math.min(sol1, sol2);
        System.out.println(result);

    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        visited = new boolean[N+1];
        Arrays.fill(distance, INF);

        // 다익스트라 시작
        queue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int currentNode = now.end;
            if (!visited[currentNode]) {
                visited[currentNode] = true;

                for (int i = 0; i < list[currentNode].size(); i++) {
                    Node next = list[currentNode].get(i);
                    int nextNode = next.end;
                    int nextWeight = next.weight;
                    if (distance[nextNode] > distance[currentNode] + nextWeight) {
                        distance[nextNode] = distance[currentNode] + nextWeight;

                        queue.offer(new Node(nextNode, distance[nextNode]));
                    }

                }
            }
        }
        return distance[end];
    }

    public static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }
}