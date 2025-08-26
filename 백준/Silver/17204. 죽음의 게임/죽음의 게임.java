import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 0, 1, 2, ... N-1의 오른쪽 사람은 다시 0번

    // 마지막으로 M 이라고 말한 사람이 벌주

    // 지목을 완료한 상태가 주어질 때, 보성이가 벌주를 마시기 위한 가장 작은 양의 정수 M

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 사람의 수
    int K = Integer.parseInt(st.nextToken()); // 보성이의 번호

    List<People> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      // i 번 사람이 지목하는 사람의 번호 a를 arr 배열에 저장
      int a = Integer.parseInt(br.readLine());
      list.add(new People(i, a));
    }

    int count = 0;
    int number = 0;
    int choose = list.get(number).choose;
    while (true) {
      number = choose;
      choose = list.get(number).choose;
      count++;

      if (number == K) {
        break;
      }

      if (count > N-1) {
        count = -1;
        break;
      }
    }

    System.out.println(count);
  }

  private static class People {
    int number;
    int choose;

    public People(int number, int choose) {
      this.number = number;
      this.choose = choose;
    }
  }
}