import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        // 가치가 큰 동전부터 선택해야 개수를 최소로 구성할 수 있음
        for (int i = N-1; i >= 0; i--) {
            if (money[i] <= K) {
                count += K / money[i];
                K = K % money[i];
            }
        }
        System.out.println(count);
    }
}