import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 수의 개수
    int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

    int[] arr = new int[N+1];
    int[] sum = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      sb.append(sum[e] - sum[s - 1]).append("\n");
    }

    System.out.println(sb);

  }
}