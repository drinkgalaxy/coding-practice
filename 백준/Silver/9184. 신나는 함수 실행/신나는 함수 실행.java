import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // -1 -1 -1 이 나오면 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a ,b ,c)).append('\n');
        }

        System.out.println(sb);

    }

    private static int w(int a, int b, int c) {
        // 이미 계산되어 저장되어 있는 경우 해당 값을 바로 반환
        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 셋 중 하나라도 20이 넘어가면 w(20, 20, 20) 호출
        // 즉, dp[20][20][20] 에 저장된 값 바로 반환
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }

    /*
     *  배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가
     *  나올 수 있기 때문에 이를 체크를 해주기 위한 함수다.
     */
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
