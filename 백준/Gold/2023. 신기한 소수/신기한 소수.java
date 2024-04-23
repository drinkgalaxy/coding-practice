import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    // DFS 구현하기
    public static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            // 짝수라면 더 이상 탐색하지 말 것
            if (i % 2 == 0) {
                continue;
            }

            // 소수라면 재귀 함수로 자릿수를 늘림
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu+1);
            }
        }
    }

    // 소수 판별 함수 구현하기
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}