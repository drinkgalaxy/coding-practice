import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[] LIS_dp;
    static Integer[] LDS_dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        LIS_dp = new Integer[n];
        LDS_dp = new Integer[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 바이토닉 수열은 점점 커지거나, 점점 작아지거나, 커졌다작아지거나

        for (int i = 0; i < n; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(LIS_dp[i] + LDS_dp[i], max);
        }

        System.out.println(max - 1);

    }

    // LIS (최장 증가 부분수열)
    private static int LIS(int n) {

        if (LIS_dp[n] == null) {
            LIS_dp[n] = 1;

            // n 이전의 노드들을 탐색
            for (int i = n - 1; i >= 0; i--) {
                // 이전의 노드 중 arr[n] 의 값보다 작은 걸 발견했을 경우
                if (arr[i] < arr[n]) {
                    LIS_dp[n] = Math.max(LIS_dp[n], LIS(i) + 1);
                }
            }
        }
        return LIS_dp[n];
    }

    // LDS (최장 감소 부분수열)
    private static int LDS(int n) {

        if (LDS_dp[n] == null) {
            LDS_dp[n] = 1;
            // n 이후의 노드들을 탐색
            for (int i = n + 1; i < LDS_dp.length; i++) {
                // 이후의 노드 중 arr[n] 의 값보다 작은 걸 발견했을 경우
                if (arr[i] < arr[n]) {
                    LDS_dp[n] = Math.max(LDS_dp[n], LDS(i) + 1);
                }
            }
        }
        return LDS_dp[n];
    }
}
