import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int size = (int) Math.pow(2, N); // 한 변의 사이즈
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    explore(size, r, c);
    System.out.println(count);
  }

  private static void explore(int size, int r, int c) {
    if (size == 1) {
      return;
    }
    // r가 size/2 보다 작, c이 size/2 보다 작 -> 2사분면
    // r가 size/2 보다 작, c이 size/2 보다 크거나 같음 -> 1사분면
    // r가 size/2 보다 크거나 같음, c이 size/2 보다 작 -> 3사분면
    // r가 size/2 보다 크거나 같음, c이 size/2 보다 크거나 같음 -> 4사분면

    if (r < size / 2 && c < size / 2) {
      explore(size / 2, r, c); // 2 사분면일 때 // 칸 방문 0
    } else if (r < size / 2 && c >= size / 2) { // 1 사분면일 때 // 칸 방문 1
      count += size * size / 4;
      explore(size / 2, r, c - size / 2);
    } else if (r >= size / 2 && c < size / 2) { // 3 사분면일 때 // 칸 방문 2
      count += (size * size / 4) * 2;
      explore(size / 2, r - size / 2, c);
    } else { // 4 사분면일 때 // 칸 방문 3
      count += (size * size / 4) * 3;
      explore(size / 2, r - size / 2, c - size / 2);
    }
  }
}