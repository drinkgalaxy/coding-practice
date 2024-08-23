import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        dp = new Integer[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0 부터 n - 1 까지 탐색
        for (int i = 0; i < n; i++) {
            getMax(i);
        }

        // 저장된 dp 배열로 최댓값 구하기
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static int getMax(int n) {

        if (dp[n] == null) {
            dp[n] = 1; // 1로 초기화
            
            // n 이전의 노드들을 탐색
            for (int i = n - 1; i >= 0; i--) {
                // 이전의 노드 중 arr[n] 보다 작은 걸 발견하면, 
                if (arr[i] < arr[n]) {
                    // dp 배열 개수 비교 후 더 큰걸 dp[n]에 저장. 새로 저장할 땐 개수 ++
                    dp[n] = Math.max(dp[n], getMax(i) + 1);
                }
            }
        }
        return dp[n];
    }

}
