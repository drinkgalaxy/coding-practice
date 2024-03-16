import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수가 주어짐
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = A * B / gcd(A, B);
            System.out.println(result);
        }
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a; // 만약 b가 0이면, a는 최대공약수
        } else {
            return gcd(b, a % b); // 작은 수, 큰 수 % 작은 수 를 재귀 함수 형태로 구현하기
        }
    }
}
