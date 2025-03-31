import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 스크린의 칸
    int M = Integer.parseInt(st.nextToken()); // 바구니의 크기
    int J = Integer.parseInt(br.readLine()); // 떨어지는 사과의 개수
    
    int[] screen = new int[N+1];

    // 바구니가 현재 차지하고 있는 칸
    int result = 0;
    Basket basket = new Basket(1, M);
    for (int i = 0; i < J; i++) {
      // 사과가 떨어지는 위치가 순서대로 주어짐
      int position = Integer.parseInt(br.readLine());
      while (true) {
        if (position < basket.s) {
          basket.s -= 1;
          basket.e -= 1;
          result++;
        } else if (position > basket.e) {
          basket.s += 1;
          basket.e += 1;
          result++;
        } else {
          break;
        }
      }
    }

    System.out.println(result);
  }

  private static class Basket {
    int s;
    int e;

    public Basket(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}