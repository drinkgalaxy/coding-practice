import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        // 행을 다 채우면 카운트를 1 증가시키고 리턴
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 depth ++ 계속 진행
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
            // 해당 행이 불가능하면 depth stop 후 다음 행으로
        }
        // 아무것도 가능하지 않으면, for 문이 끝난 후 count 는 0
    }

    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }
            // 대각선상에 놓여있는 경우
            // (= 열의 차와 행의 차가 같은 경우)
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}