import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기
        int k = Integer.parseInt(br.readLine());

        long lo = 1L;
        long hi = k;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long sum = 0L;
            // 임의의 mid 에 대해 i번째 행을 나눔으로써, mid 보다 작거나 같은 원소의 개수 누적합을 구함
            // 이때, 각 행의 원소의 개수가 N을 초과하지 않도록 한다.
            for (int i = 1; i <= N; i++) {
                sum += Math.min(mid / i, N);
            }

            if (k <= sum) {
                // 임의의 원소의 개수 누적합 sum 보다 작거나 같은 수가 B[k] 보다 많거나 같다는 뜻.
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(hi);


    }
}