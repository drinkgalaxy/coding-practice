import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 데이터의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 출력할 개수 M
        long[] sums = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken()); // N개의 수 입력받기
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sums[j] - sums[i-1]);
        }
    }
}