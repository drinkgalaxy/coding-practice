import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static boolean[] visited; // 방문 처리 배열
    static ArrayList<Node>[] list; // 그래프 저장
    static int[] distance; // 최단 경로 값 저장
    static PriorityQueue<Node> queue = new PriorityQueue<>(); // 우선순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        visited = new boolean[V+1];
        list = new ArrayList[V+1];
        distance = new int[V+1];

        // 그래프, 최단 경로 값 초기화
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 가중치가 있는 인접리스트 초기화하기.
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()); // 시작 정점
            int v = Integer.parseInt(st.nextToken()); // 도착 정점
            int w = Integer.parseInt(st.nextToken()); // 간선의 가중치

            list[u].add(new Node(v, w));
        }

        // 다익스트라 알고리즘 수행
        queue.add(new Node(K, 0)); // K를 시작점으로 설정하기
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int endNode = current.end;
            if (!visited[endNode]) {
                visited[endNode] = true;

                for (int i = 0; i < list[endNode].size(); i++) {
                    Node tmp = list[endNode].get(i);
                    int next = tmp.end;
                    int weight = tmp.weight;
                    if (distance[next] > distance[endNode] + weight) {
                        distance[next] = distance[endNode] + weight; // distance[next]를 최소 거리로 업데이트

                        queue.add(new Node(next, distance[next]));
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }

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