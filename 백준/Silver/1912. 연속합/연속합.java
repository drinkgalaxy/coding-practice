import java.io.*;
import java.util.*;


public class Main {
    static Integer[] dp; // 메모이제이션 dp
    static int[] arr; // 배열
    static int value = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0]; // 첫 원소 초기화
        value = arr[0]; // 첫 원소 초기화

        // dp의 마지막 index 는 n - 1
        calculate(n - 1);

        System.out.println(value);
    }

    public static int calculate(int n) {
        // 탐색하지 않은 인덱스라면
        if (dp[n] == null) {
            // (이전 배열의 누적합 + 현재 값) 과 현재 값을 비교하여 최댓값을 저장
            dp[n] = Math.max(calculate(n - 1) + arr[n], arr[n]);
            value = Math.max(dp[n], value);
        }

        return dp[n];
    }
}