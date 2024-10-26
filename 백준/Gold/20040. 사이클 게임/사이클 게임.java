import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 각각 i번째 차례에 플레이어가 선택한 두 점 a, b의 정보
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            // 연결했을 때 마다 사이클이 생겼는지 확인
            if (find(a) == find(b)) {
                result = i;
                break;
            }
            // 같은 집합이 아니면 합집합 수행
            union(a, b);
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}