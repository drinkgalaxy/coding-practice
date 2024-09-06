import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken()); // 가진 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] arr = new int[K];

        long max = 0;

        // 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하며 max 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // max 에서 +1 값이어야 한다.
        // mid 가 0이 되어서 0을 나눗셈하는 걸 막기 위함이다.
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2; // 범위 내에서 중간 길이

            long count = 0;

            // 구한 중간 길이로 잘라서 총 몇 개가 만들어지는지 구함.
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            // mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
            // 최대 길이를 줄인다.
            // 그 외에는 최소 길이를 늘린다.
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
        
    }
}
