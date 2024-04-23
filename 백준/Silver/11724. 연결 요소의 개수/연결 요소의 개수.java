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
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 방향이 없는 그래프이기 때문에 양방향 저장
            A[start].add(end);
            A[end].add(start);
        }

        /// 연결 요소 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    public static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : A[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }

}