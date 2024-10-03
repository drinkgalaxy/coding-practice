import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (key > LIS[lengthOfLIS-1]) {
                lengthOfLIS++;
                LIS[lengthOfLIS-1] = key;
            } else {
                // 탐색하는 값보다 큰, 가장 가까운 원소를 찾아야됨 -> 하한값 탐색
                int min = 0;
                int max = lengthOfLIS;

                while (min < max) {
                    int mid = (min + max) / 2;

                    if (key <= LIS[mid]) {
                        max = mid;
                    } else {
                        min = mid+1;
                    }
                }
                LIS[max] = key;
            }
        }

        System.out.println(lengthOfLIS);
    }
}