import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 생성할 바구니의 크기 N 정하기 (배열의 크기)
        int N = Integer.parseInt(st.nextToken());
        int [] basket = new int [N];
        int [] temp = new int [N];

        // 처음 바구니에 1부터 N 까지 공 넣기
        for (int i = 0; i < basket.length; i++) {
            basket[i] = i+1;
        }

        // 공을 바꿀 횟수 M 정하기 (반복 횟수)
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 공을 바꿀 바구니 2개를 선택 (a, b)
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            temp[a-1] = basket[a-1];
            basket[a-1] = basket[b-1];
            basket[b-1] = temp[a-1];
        }
        for (int i = 0; i < basket.length; i++) {
            System.out.print(basket[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}