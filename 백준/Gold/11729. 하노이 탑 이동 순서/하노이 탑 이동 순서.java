import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    sb.append((int)(Math.pow(2, N) - 1)).append("\n");
    // 하노이 탑의 이동 횟수는 정확하게 2^N - 1 번
    hanoi(N, 1, 2, 3);
    System.out.println(sb);

  }

  private static void hanoi(int n, int from, int mid, int to) {
    if (n == 1) {
      sb.append(from).append(" ").append(to).append("\n");
      return;
    }

    // n - 1 개의 원판이 첫 번째 장대에서 두 번째 장대로 가야 함
    hanoi(n - 1, from, to, mid);

    // 그 다음 가장 큰 원판이 세 번째 장대로 이동하는 횟수는 1회
    sb.append(from).append(" ").append(to).append("\n");

    // 마지막으로 두 번째 장대에 있는 n - 1 개의 원판이 세 번째 장대로 가야 함
    hanoi(n - 1, mid, from, to);

  }

}