import java.io.*;
import java.util.*;

public class Main {
    static int[] students;    // students[i]: i번째 학생이 선택한 학생 번호
    static boolean[] visited; // 방문 여부
    static boolean[] finished; // 탐색 완료 여부 (사이클 판별용)
    static int count;         // 사이클에 포함된 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append(n - count).append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = students[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발견, 사이클에 포함된 노드 수 세기
            for (int i = next; i != cur; i = students[i]) {
                count++;
            }
            count++; // cur 포함
        }

        finished[cur] = true;
    }
}
