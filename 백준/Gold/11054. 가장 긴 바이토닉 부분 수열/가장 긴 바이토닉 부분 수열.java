import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[] LIS_dp;
    static Integer[] LDS_dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LIS_dp = new Integer[N];
        LDS_dp = new Integer[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(LIS_dp[i] + LDS_dp[i], max);
        }

        System.out.println(max - 1);

    }

    private static int LIS(int n) { // 최장 증가 부분수열
        if (LIS_dp[n] == null) {
            LIS_dp[n] = 1;

            // n 이전의 노드들을 탐색
            for (int i = n-1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    LIS_dp[n] = Math.max(LIS_dp[n], LIS(i) + 1);
                }
            }
        }
        return LIS_dp[n];
    }

    private static int LDS(int n) { // 최장 감소 부분수열
        if (LDS_dp[n] == null) {
            LDS_dp[n] = 1;

            // n 이후의 노드들을 탐색
            for (int i = n+1; i < LDS_dp.length; i++) {
                if (arr[i] < arr[n]) {
                    LDS_dp[n] = Math.max(LDS_dp[n], LDS(i) + 1);
                }
            }
        }
        return LDS_dp[n];
    }
}