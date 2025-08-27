import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // f(A) = A의 모든 약수를 더한 값, 즉 A의 약수 합
    // g(N) = f(1) + f(2) + ... + f(N) 을 모두 더한 값, 즉 1부터 N 까지의 약수 합 전체

    // 어떤 수 y가 있을 때, 그 약수 중 하나를 d라고 한다면
    // y는 d의 배수이다. 즉, y = d * k이다.
    // d가 약수로 등장하는 횟수 = N 이하의 d의 배수 개수 = N / d
    // 따라서 d가 전체 합에 기여하는 값 = d * (N / d)

    int N = Integer.parseInt(br.readLine());

    long result = 0;
    for (int i = 1; i <= N; i++) {
      result += (long) i * (N / i);
    }
    System.out.println(result);
  }
}