import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int[] length = new int[N-1]; // 도로의 길이
        int[] charge = new int[N]; // 주우소의 리터당 가격
        int value = 0; // 비용

        // 데이터 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length.length; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < charge.length; i++) {
            charge[i] = Integer.parseInt(st.nextToken());
        }

        // 도시의 가격 비교
        for (int i = 0; i < charge.length - 1; i++) {
            // 현재 도시의 가격의 더 싸다
            if (charge[i] < charge[i+1]) {
                // 다다음 도시 것 까지 충전
                value += (charge[i] * (length[i] + length[i+1]));
                i++;
            // 현재 도시의 가격이 더 비싸다
            } else {
                value += (charge[i] * length[i]);
            }
        }

        System.out.println(value);
    }
}
