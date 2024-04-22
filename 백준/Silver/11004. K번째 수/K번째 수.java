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
        // 퀵 정렬은 항상 start가 end보다 작을 때 진행됨.
        if (start < end) {
            int pivot = Partition(A, start, end);
            if (pivot == K) { // 일치하는 K를 찾았으니 바로 return
                return;
            } else if (pivot < K) {
                QuickSort(A, pivot+1, end, K);
            } else {
                QuickSort(A, start, pivot-1, K);
            }
        }
    }

    public static int Partition(int[] A, int start, int end) {
        // 데이터가 2개인 경우는 바로 비교하여 정렬 
        if (start + 1 == end) {
            if (A[start] > A[end]) {
                Swap(A, start, end);
                return end;
            }
        }
        int mid = (start + end) / 2;
        Swap(A, start, mid);
        int pivot = A[start]; // pivot을 시작 위치 값(시작 위치와 swap된 중앙값)으로 지정
        
        int i = start + 1;
        int j = end;
        while (i <= j) {
            // end가 가리키는 데이터가 pivot보다 크면 end를 왼쪽으로 한칸 이동
            while (j >= start + 1 && pivot < A[j]) {
                j--;
            }
            // start+1가 가리키는 데이터가 pivot보다 작으면 start+1를 오른쪽으로 한칸 이동
            while (i <= end && pivot > A[i]) {
                i++;
            }
            // 둘이 만나면 Swap
            if (i <= j) {
                Swap(A, i++, j--);
            }
        }
        // pivot 데이터를 나눠진 두 그룹의 경계 index에 저장하는 과정
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
