import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long maxResult = -1000000000;
    public static long minResult = 1000000000;
    public static int[] number;
    public static int[] operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 개수
        number = new int[N]; // 수열을 담을 배열
        operator = new int[4]; // 연산자를 담을 배열

        // 수열 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 저장
        st = new StringTokenizer(br.readLine());
        operator[0] = Integer.parseInt(st.nextToken());
        operator[1] = Integer.parseInt(st.nextToken());
        operator[2] = Integer.parseInt(st.nextToken());
        operator[3] = Integer.parseInt(st.nextToken());

        Dfs(number[0], 1);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // 연산자 만들기
    public static void Dfs(int currentResult, int depth) {
        // depth 가 number.length 랑 길이가 같아지면 종료
        if (depth == number.length) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        // number 의 index depth 를 ++ 해가면서
        for (int i = 0; i < 4; i++) {
            // 연산자가 있으면
            if (operator[i] > 0) {
                operator[i]--;
                // 계속 탐색
                if (i == 0) {
                    Dfs(currentResult + number[depth], depth + 1);
                } else if (i == 1) {
                    Dfs(currentResult - number[depth], depth + 1);
                } else if (i == 2) {
                    Dfs(currentResult * number[depth], depth + 1);
                } else {
                    if (currentResult < 0) {
                        Dfs(currentResult * -1 / number[depth] * -1, depth + 1);
                    } else {
                        Dfs(currentResult / number[depth], depth + 1);
                    }
                }
                // 각 연산자로 되돌리기
                operator[i]++;
            }
        }
    }
}