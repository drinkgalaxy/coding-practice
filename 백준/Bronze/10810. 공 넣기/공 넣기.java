import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 생성할 바구니의 크기 N 정하기 (배열의 크기)
        int N = Integer.parseInt(st.nextToken());
        int [] basket = new int [N];

        // 입력 줄의 개수 M 정하기 (반복 횟수)
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 배열 a 부터 b 까지 c 숫자의 공으로 채우기
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = a - 1; j < b; j++) {
                basket[j] = c;
            }
        }
        for (int i = 0; i < basket.length; i++) {
            System.out.print(basket[i]+" ");
        }
    }
}
