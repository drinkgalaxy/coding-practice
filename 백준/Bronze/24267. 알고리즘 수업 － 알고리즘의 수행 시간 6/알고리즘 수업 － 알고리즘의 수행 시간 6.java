import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 알고리즘의 수행 횟수, 알고리즘의 수행 횟수 다항식의 최고차항의 차수 출력
        long n = Integer.parseInt(br.readLine());
        System.out.println((n * (n-1) * (n-2)/6));
        System.out.println(3);

    }
}