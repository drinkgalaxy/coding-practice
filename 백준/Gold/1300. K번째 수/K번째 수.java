import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        int k = Integer.parseInt(br.readLine()); // k

        // 임의의 x 는 lo <= x <= hi 의 범위를 갖는다.
        long lo = 1;
        long hi = k;

        while (lo < hi) {
            long mid  = (lo + hi) / 2;
            long count = 0L;

            // 임의의 x에 대해 i번째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
            // 누적 합을 구한다.
            // 이때 각 행의 원소의 개수가 N 을 초과하지 않는 선에서 합해주어야 한다.
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // k보다 count 가 크거나 같다는 것은
            // 임의의 x보다 작은 수가 B[K] 보다 많거나 같다는 뜻이다.
            // 그럼 줄여준다.
            if (k <= count) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
