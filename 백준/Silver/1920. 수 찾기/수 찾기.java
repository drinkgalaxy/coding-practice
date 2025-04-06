import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      sb.append(isExist(num) ? 1 : 0).append("\n");
    }

    System.out.println(sb);
  }

  private static boolean isExist(int target) {
    int s = 0;
    int e = arr.length - 1;
    while (s <= e) {

      int mid = (s + e) / 2;

      if (target < arr[mid]) {
        e = mid - 1;
      } else if (target > arr[mid]) {
        s = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}