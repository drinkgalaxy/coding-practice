import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        // 1부터 n-1까지 모든 수를 확인
        for (int i = 0; i < n; i++) {
            int number = i;
            int sum = 0; // 각 자릿수 합 변수

            while (number != 0) {
                sum += number % 10; // 각 자릿수 더하기
                number /= 10; // 다음 자릿수로 이동
            }

            if (sum + i == n) { // 생성자를 찾았을 경우
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}