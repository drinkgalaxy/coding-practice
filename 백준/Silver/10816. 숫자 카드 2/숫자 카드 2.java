import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수 N
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine()); // 비교할 숫자 M
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(getMax(target)+1 - getMin(target)).append(" ");
        }

        System.out.println(sb);
    }
    private static int getMax(int target) {
        int minIndex = 0;
        int maxIndex = arr.length;

        while (minIndex < maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            if (target < arr[midIndex]) {
                maxIndex = midIndex;
            } else {
                minIndex = midIndex+1;
            }
        }
        return minIndex-1; // 상한값
    }

    private static int getMin(int target) {
        int minIndex = 0;
        int maxIndex = arr.length;

        while (minIndex < maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            if (target <= arr[midIndex]) {
                maxIndex = midIndex;
            } else {
                minIndex = midIndex+1;
            }
        }
        return maxIndex; // 하한값
    }

}