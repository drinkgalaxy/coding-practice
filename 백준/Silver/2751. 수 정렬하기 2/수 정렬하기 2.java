import java.io.*;
import java.util.*;

public class Main {
    public static int[] A, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        temp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        MergeSort(1, N);
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]+"\n");
        }
        System.out.println(sb);
    }

    public static void MergeSort(int start, int end) {
        if (end-start < 1) {
            return;
        }
        int mid = start + (end-start) / 2;
        MergeSort(start, mid);
        MergeSort(mid+1, end);
        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        // 두 그룹을 병합하는 로직
        int k = start;
        int index1 = start;
        int index2 = mid+1;
        while (index1 <= mid && index2 <= end) {
            if (temp[index1] < temp[index2]) {
                A[k] = temp[index1];
                k++;
                index1++;
            } else {
                A[k] = temp[index2];
                k++;
                index2++;
            }
        }
        // 한쪽 그룹이 모두 선택된 후 남아있는 값 정리
        while (index1 <= mid) {
            A[k] = temp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}