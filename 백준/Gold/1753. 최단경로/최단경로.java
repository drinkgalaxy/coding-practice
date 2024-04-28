import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int value;
    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
    public int compareTo(Edge e) {
        if (this.value > e.value) {
            return 1;
        } else {
            return -1;
        }
    }
}


public class Main {
    static int V, E, K;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge> list[];
    static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        distance = new int[V+1];
        list = new ArrayList[V+1];
        // 그래프 데이터를 저장할 인접 리스트 초기화
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }

        // 거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        // 다익스트라 알고리즘 수행
        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) { // 초기값을 add 한 후에 일단 while 때리기
            Edge nowNode = queue.poll();
            int nowVertex = nowNode.vertex;
            if (visited[nowVertex]) {
                continue;
            } else {
                visited[nowVertex] = true;
                for (int i = 0; i < list[nowVertex].size(); i++) {
                    Edge temp = list[nowVertex].get(i);
                    int next = temp.vertex;
                    int value = temp.value;
                    if (distance[next] > distance[nowVertex] + value) {
                        distance[next] = distance[nowVertex] + value;
                        queue.add(new Edge(next, distance[next]));
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
}
