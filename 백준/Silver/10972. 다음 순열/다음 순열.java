import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    static boolean nextPermutation(int[] arr) {
        int i = N - 1;

        // 1. 뒤에서 오름차순 깨지는 지점 찾기
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i <= 0) return false; // 마지막 순열

        // 2. arr[i-1]보다 큰 값 찾기
        int j = N - 1;
        while (arr[j] <= arr[i - 1]) j--;

        // 3. 교환
        swap(arr, i - 1, j);

        // 4. 뒷부분 뒤집기
        j = N - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
