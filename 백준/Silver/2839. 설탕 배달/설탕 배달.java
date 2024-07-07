
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배달할 때 최대한 적은 봉지를 가져가기 위해 큰 킬로그램부터 차감
        // 봉지는 3킬로그램과 5킬로그램
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1]; // 봉지가 몇 개 필요한 지 저장하는 배열

        if (N >= 3) {
            dp[3] = 1;
        }
        if (N >= 5) {
            dp[5] = 1;
        }
        for (int i = 6; i < dp.length; i++) {
            // 5랑 3으로 다 나눠지는 숫자면 5가 먼저 체크되어야 최솟값이 됨.
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            // 5나 3으로 모두 안나눠지는 숫자
            } else {
                if (dp[i - 5] == 0 && dp[i - 3] == 0) {
                    dp[i] = -1;
                } else if (dp[i - 5] == 0 && dp[i - 3] != 0) {
                    dp[i] = dp[i - 3] + 1;
                } else if (dp[i - 5] != 0 && dp[i - 3] == 0) {
                    dp[i] = dp[i - 5] + 1;
                } else if (dp[i - 5] != 0 && dp[i - 3] != 0) {
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                }
            }
        }
        if (dp[N] > 0) {
            System.out.println(dp[N]);
        } else {
            System.out.println(-1);
        }
    }
}