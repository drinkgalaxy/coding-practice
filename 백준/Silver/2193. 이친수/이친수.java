import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] array = new long[N+1][2];
        array[1][1] = 1; // 1자리 이친수는 단 1가지
        array[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            // i번째 0으로 끝나는 개수
            array[i][0] = array[i-1][1] + array[i-1][0]; // 0은 이전단계의 0과 1로 끝나는 모든 경우에 붙일 수 있음
            // i번째 1로 끝나는 개수
            array[i][1] = array[i-1][0]; // 1은 이전 단계의 0으로 끝나는 모든 경우만 붙일 수 있음
        }
        System.out.println(array[N][0] + array[N][1]);

    }
}

