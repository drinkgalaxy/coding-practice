import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 A 의 크기

        int[] arr = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            // 만약 key 가 LIS 의 마지막 값보다 클 경우 추가
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            // 아닐 경우 탐색하는 값보다 큰 가장 가까운 원소를 찾기 위해
            // Lower Bound 이분탐색 진행
            } else {
                int lo = 0;
                int hi = lengthOfLIS;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if (key <= LIS[mid]) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                // lo 가 LIS 에서 대치 될 원소의 위치가 됨.
                LIS[lo] = key;
            }
        }

        System.out.println(lengthOfLIS);
    }
}
