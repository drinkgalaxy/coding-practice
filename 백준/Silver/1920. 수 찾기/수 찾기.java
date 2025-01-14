import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    int[] mrr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      mrr[i] = Integer.parseInt(st.nextToken());
      if (binarySearch(mrr[i])) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }

    System.out.println(sb);
  }

  public static boolean binarySearch(int target) {
    int lo = 0;
    int hi = arr.length-1;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (arr[mid] < target) {
        lo = mid + 1;
      } else if (arr[mid] > target) {
        hi = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
