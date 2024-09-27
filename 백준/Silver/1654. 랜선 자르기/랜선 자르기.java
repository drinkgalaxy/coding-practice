import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /*
        K 개의 랜선을 잘라 N개의 같은 길이의 랜선으로 만들어야 함.
        이때 만들 수 있는 최대 랜선의 길이
        -> 이분탐색으로 상한값-1 출력
         */
        int K = Integer.parseInt(st.nextToken()); // 원래 가진 랜선의 개수
        long N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] arr = new int[K];

        long max = 0; // 최댓값 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max++; // 나눴을 때 0이 됨을 막기위해 max+1을 해줌.
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}