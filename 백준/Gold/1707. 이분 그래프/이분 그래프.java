import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            colors = new int[V+1];

            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean check = true;
            for (int j = 1; j <= V; j++) {
                if (colors[j] == 0) {
                    if (!BFS(j)) {
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

    private static boolean BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colors[node] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i = 0; i < graph.get(n).size(); i++) {
                int now = graph.get(n).get(i);
                if (colors[n] == colors[now]) {
                    return false;
                }
                if (colors[now] == 0) {
                    queue.offer(now);
                    colors[now] = colors[n] * -1; // 반대색 저장
                }
            }
        }
        return true;
    }
}
