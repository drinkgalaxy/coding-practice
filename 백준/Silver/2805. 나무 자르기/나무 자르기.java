import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Integer.parseInt(st.nextToken()); // 나무의 길이 (target)

        // 절단기 길이를 기준으로
        long max = 2000000000L;
        long min = 0L;
        long mid = 0L;

        // 데이터 길이
        st = new StringTokenizer(br.readLine(), " ");
        long[] trees = new long[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        while (min < max) {
            mid = (min + max) / 2;

            long count = 0;
            for (long tree : trees) {
                if (tree - mid > 0) {
                    count += (tree - mid);
                }
            }
            // count 가 M 보다 작다는 것은
            // 잘라야하는 개수보다 더 위를 잘랐다는 것
            // 그럼 낮춰줘야 함
            if (count < M) {
                max = mid;
            // count 가 M 보다 크다는 것은
            // 잘라야하는 개수보다 더 아래를 잘랐다는 것
            // 그럼 높여줘야 함
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
