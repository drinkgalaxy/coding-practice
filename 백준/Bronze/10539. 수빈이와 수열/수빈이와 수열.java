import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 수열의 길이
    int[] arr = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    sb.append(arr[0]).append(" "); // 처음 등장 숫자
    int sum = arr[0];

    for (int i = 1; i < N; i++) {
      int num = (arr[i] * (i+1)) - sum;
      sb.append(num).append(" ");
      sum += num;
    }

    System.out.println(sb);
  }
}
 