import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        QuickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }
    public static void QuickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivot = Partition(A, start, end);
            if (pivot == K) {
                return;
            } else if (pivot < K) {
                QuickSort(A, pivot+1, end, K);
            } else {
                QuickSort(A, start, pivot-1, K);
            }
        }
    }

    public static int Partition(int[] A, int start, int end) {
        if (start + 1 == end) {
            if (A[start] > A[end]) {
                Swap(A, start, end);
                return end;
            }
        }
        int mid = (start + end) / 2;
        Swap(A, start, mid);
        int pivot = A[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (j >= start + 1 && pivot < A[j]) {
                j--;
            }
            while (i <= end && pivot > A[i]) {
                i++;
            }
            if (i <= j) {
                Swap(A, i++, j--);
            }
        }
        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void Swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}