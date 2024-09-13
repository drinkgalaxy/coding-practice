import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프 정보 저장
    static int[] visited; // 방문 배열
    static int count; // 방문 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점 (1)

        visited = new int[N+1]; // 시작 정점이 1부터 시작함

        // 초기화
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 데이터 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 무방향이므로 양쪽에 정보를 추가
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        // 오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        count = 1;
        dfs(R);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        visited[n] = count; // 방문 배열 저장
        for (int i = 0; i < graph.get(n).size(); i++) {
            int newVertex = graph.get(n).get(i); // 정점 리스트 순회
            if (visited[newVertex] == 0) { // 방문 하지 않은 배열이면, 
                count++;
                dfs(newVertex);
            }
        }
    }
}
