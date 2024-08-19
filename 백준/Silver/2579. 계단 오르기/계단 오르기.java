import java.io.*;

public class Main {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new Integer[N + 1];

        // 데이터 저장
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        // index 0은 시작점
        dp[0] = arr[0]; // 0으로 초기화
        dp[1] = arr[1];

        // N이 1일 경우를 대비해서 2 이상일 때만 dp[2]를 초기화
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(getMax(N));
    }

    public static int getMax(int N) {

        // 탐색하지 않은 값에 메모이제이션 저장
        if (dp[N] == null) {
            dp[N] = Math.max(getMax(N - 2), getMax(N - 3) + arr[N - 1]) + arr[N];
        }

        // 리턴
        return dp[N];
    }

}
