import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] A;
    public static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // A 인접 리스트 초기화
        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // A 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        // 정점 번호가 작은 것을 먼저 방문하기 위해 A 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // 방문 배열 리스트 초기화 후 DFS, BFS 실행
        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
        System.out.println();
    }

    public static void DFS(int node) {
        System.out.print(node+" ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
        int nowNode = queue.poll();
        System.out.print(nowNode+" ");
        for (int i : A[nowNode]) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                }
            }
        }
    }
}