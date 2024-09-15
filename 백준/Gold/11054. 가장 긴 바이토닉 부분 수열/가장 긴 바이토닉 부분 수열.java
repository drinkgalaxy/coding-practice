import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int[] arr;
    static Integer[] LIS_dp;
    static Integer[] LDS_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        LIS_dp = new Integer[N];
        LDS_dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS, LDS 각각 수행
        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(LIS_dp[i] + LDS_dp[i], max);
        }

        System.out.println(max-1);
    }

    public static int LIS(int n) {
        if (LIS_dp[n] == null) {
            LIS_dp[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    LIS_dp[n] = Math.max(LIS_dp[n], LIS(i)+1);
                }
            }
        }
        return LIS_dp[n];
    }

    public static int LDS(int n) {
        if (LDS_dp[n] == null) {
            LDS_dp[n] = 1;

            for (int i = n+1; i < LDS_dp.length; i++) {
                // 역방향으로 탐색
                if (arr[i] < arr[n]) {
                    LDS_dp[n] = Math.max(LDS_dp[n], LDS(i)+1);
                }
            }
        }
        return LDS_dp[n];
    }
}