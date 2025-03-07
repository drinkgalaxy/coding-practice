import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int totalMoney = money1(a) + money2(b);
      sb.append(totalMoney).append("\n");
    }

    System.out.println(sb);
  }

  static int money1(int x) {
    if (x == 1) {
      return 5000000;
    } else if (x > 1 && x <= 3) {
      return 3000000;
    } else if (x > 3 && x <= 6) {
      return 2000000;
    } else if (x > 6 && x <= 10) {
      return 500000;
    } else if (x > 10 && x <= 15) {
      return 300000;
    } else if (x > 15 && x <= 21) {
      return 100000;
    } else {
      return 0;
    }
  }

  static int money2(int x) {
    if (x == 1) {
      return 5120000;
    } else if (x > 1 && x <= 3) {
      return 2560000;
    } else if (x > 3 && x <= 7) {
      return 1280000;
    } else if (x > 7 && x <= 15) {
      return 640000;
    } else if (x > 15 && x <= 31) {
      return 320000;
    } else {
      return 0;
    }
  }
}
 