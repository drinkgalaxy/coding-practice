import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer. parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
        int i = 0;
        int j = N - 1;
        int count = 0;
        int[] arr = new int[N]; // 재료들의 고유한 번호들
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
            arr[k] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        while (i < j) {
            if (arr[i] + arr[j] > M) {
                j--;
            } else if (arr[i] + arr[j] < M) {
                i++;
            } else {
                i ++;
                j --;
                count++;
            }
        }
        System.out.println(count);
    }
}
