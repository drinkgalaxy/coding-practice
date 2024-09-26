import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int l = 0;
            int r = arr.length-1;
            boolean find = false;

            while (l <= r) {
                int midIndex = (l + r) / 2;

                if (arr[midIndex] < target) {
                    l = midIndex+1;
                } else if (target < arr[midIndex]) {
                    r = midIndex-1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}