import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 별 n줄 찍을 때 까지 증가
        // 별 n줄 찍으면 하나씩 감소
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = n-1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = n * 2 - 2; j >= i * 2; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
