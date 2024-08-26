import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] wire;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 전봇대 개수
        // wire[N][0] = A 전봇대, wire[N][1] = B 전봇대
        wire = new int[N][2];
        dp = new Integer[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // Comparator 를 사용하여 2차원 배열 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // A 전봇대 기준으로 정렬
            }
        });

        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(LIS(i), max);
        }

        System.out.println(N - max);

    }

    public static int LIS(int N) {
        if (dp[N] == null) {
            dp[N] = 1;

            // A의 N 번째와 이후의 전봇대를 비교
            for (int i = N + 1; i < dp.length; i++) {
                if (wire[N][1] < wire[i][1]) {
                    dp[N] = Math.max(dp[N], LIS(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
