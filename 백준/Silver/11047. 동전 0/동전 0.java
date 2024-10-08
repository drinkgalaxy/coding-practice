import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동전 종류의 개수
        int K = Integer.parseInt(st.nextToken()); // 목적 가치의 합

        int[] money = new int[N];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = money.length-1; i >= 0; i--) {
            if (money[i] <= K) {
                count += K / money[i];
                K = K % money[i];
            }
        }

        System.out.println(count);
    }
}
