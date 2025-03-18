import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int A, B, C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    int[] parking = new int[101];
    for (int i = 1; i <= 3; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      for (int j = s; j < e; j++) {
        parking[j]++;
      }
    }

    int result = 0;
    for (int i = 1; i < parking.length; i++) {
      result += parking[i] * calculate(parking[i]);
    }
    System.out.println(result);
  }

  private static int calculate(int car) {
    if (car == 1) {
      return A;
    } else if (car == 2) {
      return B;
    } else if (car == 3) {
      return C;
    } else {
      return 0;
    }
  }
}
