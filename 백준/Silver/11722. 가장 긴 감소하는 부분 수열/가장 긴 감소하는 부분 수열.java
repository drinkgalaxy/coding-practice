import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[] LDS_dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        LDS_dp = new Integer[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            LDS(i);
        }

        int max = LDS_dp[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(LDS_dp[i], max);
        }

        System.out.println(max);

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
