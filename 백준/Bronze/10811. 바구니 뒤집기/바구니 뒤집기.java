import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 첫째 줄에 N(바구니의 개수)과 M(반복횟수)이 주어짐
        int N = Integer.parseInt(st.nextToken());
        int[] basket = new int [N];
        int[] temp = new int [1];

        for (int i = 0; i < basket.length; i++) {
            basket[i] = i+1; // 1부터 시작해야 하기 때문에 1을 더해줌.
        }

        int M = Integer.parseInt(st.nextToken());
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            // 공을 뒤집을 바구니 2개를 선택 (i, j)
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            while (i < j) {
                temp[0] = basket[j-1];
                basket[j-1] = basket[i-1];
                basket[i-1] = temp[0];
                i++;
                j--;
            }
        }

        for (int i = 0; i < basket.length; i++) {
            System.out.print(basket[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
