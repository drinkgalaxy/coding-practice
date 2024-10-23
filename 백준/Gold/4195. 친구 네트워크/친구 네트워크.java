import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] friendC;
    static HashMap<String, Integer> names;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테케
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine()); // 친구 관계의 수
            names = new HashMap<>(); // names 해시맵 테케마다 초기화
            parent = new int[F*2];
            friendC = new int[F*2];
            Arrays.fill(friendC, 1); // 처음 친구수는 1명

            for (int j = 0; j < F * 2; j++) {
                parent[j] = j; // 자신의 부모를 자신으로 설정
            }

            int nowIdx = 0; // 들어오는 친구의 인덱스 같이 저장
            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String n1 = st.nextToken();
                String n2 = st.nextToken();

                if (!names.containsKey(n1)) {
                    names.put(n1, nowIdx++);
                }
                if (!names.containsKey(n2)) {
                    names.put(n2, nowIdx++);
                }

                // 친구들의 인덱스
                int idx1 = names.get(n1);
                int idx2 = names.get(n2);

                // 친구들의 부모
                int parent1 = find(idx1);
                int parent2 = find(idx2);

                if (parent1 == parent2) { // 이미 친구인 경우는 그냥 추가
                    sb.append(friendC[parent1]).append("\n");
                } else {
                    int tmp = union(idx1, idx2); // 더 작은 값의 조상값 리턴
                    sb.append(friendC[tmp]).append("\n"); // 반환된 조상의 친구수 출력
                }
            }
        }
        System.out.println(sb);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            friendC[a] += friendC[b]; // 친구의 합
            return parent[b] = a;
        } else {
            friendC[b] += friendC[a];
            return parent[a] = b;
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class Node {
        String name;

        public Node(String name) {
            this.name = name;
        }
    }
}