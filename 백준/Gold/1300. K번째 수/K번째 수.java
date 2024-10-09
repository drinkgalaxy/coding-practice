import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        int k = Integer.parseInt(br.readLine()); // k

        long lo = 1;
        long hi = k;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0L;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (k <= count) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(hi);
    }
}