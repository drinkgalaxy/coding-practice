import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        long[] length = new long[N-1]; // 도로의 길이
        long[] charge = new long[N]; // 주우소의 리터당 가격

        // 데이터 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length.length; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < charge.length; i++) {
            charge[i] = Integer.parseInt(st.nextToken());
        }

        long value = 0;
        long minCost = charge[0]; // 이전 까지의 과정 중 주유 최소 비용

        // 도시의 가격 비교
        for (int i = 0; i < charge.length - 1; i++) {
            if (charge[i] < minCost) {
                minCost = charge[i];
            }

            value += (minCost * length[i]);
        }

        System.out.println(value);
    }
}
