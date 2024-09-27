import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors; // 1/-1 서로 다르게 구분. 0은 아직 탐색하지 않은 색
    static int V, E;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수
            graph = new ArrayList<>();
            colors = new int[V+1];

            // 초기화
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) { // 간선에 대한 정보 주어짐
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // BFS 실행
            check = true; // 그래프가 이분 그래프인가? true 로 시작
            for (int j = 1; j <= V; j++) {
                if (colors[j] == 0) { // 방문하지 않았으면,
                    if (!bfs(j)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer i : graph.get(now)) {
                if (colors[now] == colors[i]) {
                    return false;
                }
                if (colors[i] == 0) {
                    queue.offer(i);
                    colors[i] = colors[now] * -1;
                }
            }
        }
        return true;
    }
}