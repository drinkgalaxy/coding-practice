import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int start = 0;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    start = Integer.parseInt(br.readLine());

    System.out.println(calculate(start));
  }

  private static int calculate(int n) {

    int sum = sum(n);
    int result = concat(n, sum);

    count++;

    if (result == start) {
      return count;
    } else {
      return calculate(result);
    }
  }

  private static int sum(int n) {
    int sum = 0;
    if (n < 10) {
      sum = n;
    } else {
      for (String s : String.valueOf(n).split("")) {
        sum += Integer.parseInt(s);
      }
    }
    return sum;
  }

  // 주어진 수의 가장 오른쪽 자리 수 + 구한 합의 가장 오른쪽 자리 수 붙이기
  private static int concat(int n, int sum) {
    StringBuilder result = new StringBuilder();

    String sn = String.valueOf(n);
    String ssum = String.valueOf(sum);


    result.append(sn.charAt(sn.length() - 1));
    result.append(ssum.charAt(ssum.length() - 1));

    return Integer.parseInt(result.toString());
  }
}
