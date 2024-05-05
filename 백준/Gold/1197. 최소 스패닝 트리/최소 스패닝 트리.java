import java.io.*;
import java.util.*;

class pEdge implements Comparable<pEdge> {
    int start;
    int end;
    int cost;

    public pEdge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(pEdge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int V, E;
    static int[] parent;
    static PriorityQueue<pEdge> queue = new PriorityQueue<pEdge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 0; i < V; i++) { // 각자 자신의 값으로 대표 노드 저장 배열 초기화
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) { // 큐에 에지 정보 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            queue.add(new pEdge(start, end, cost));
        }
        int useEdge = 0;
        int result = 0;
        while (useEdge < V - 1) {
            pEdge now = queue.poll();
            if (find(now.start) != find(now.end)) { // 사이클이 없으면
                union(now.start, now.end);
                result = result + now.cost;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}