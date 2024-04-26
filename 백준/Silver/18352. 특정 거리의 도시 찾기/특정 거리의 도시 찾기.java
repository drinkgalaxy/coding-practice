import java.io.*;
import java.util.*;

public class Main {
    static int N,M, K, X;
    static int visited[];
    static ArrayList<Integer>[] A;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 수
        M = Integer.parseInt(st.nextToken()); // 에지의 수
        K = Integer.parseInt(st.nextToken()); // 목표 거리
        X = Integer.parseInt(st.nextToken()); // 시작점
        A = new ArrayList[N+1];
        answer = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접 리스트에 그래프 데이터 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
        }

        // 방문 배열 초기화
        visited = new int[N+1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (K == visited[i]) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                int temp = answer.get(i);
                System.out.println(temp);
            }
        }

    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node]++;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i : A[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode]+1;
                    queue.add(i);
                }
            }
        }
    }
}