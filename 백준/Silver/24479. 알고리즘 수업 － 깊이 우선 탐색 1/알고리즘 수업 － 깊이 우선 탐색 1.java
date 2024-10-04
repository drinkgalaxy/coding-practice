import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        count = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] != 0) {
                sb.append(visited[i]).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (visited[start] == 0) {
            visited[start] = count++;

            for (int i = 0; i < list.get(start).size(); i++) {
                int next = list.get(start).get(i);
                dfs(next);
            }
        }
    }
}