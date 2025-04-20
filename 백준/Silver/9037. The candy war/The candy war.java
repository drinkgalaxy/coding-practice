import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine()); // 테케

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {

      int N = Integer.parseInt(br.readLine()); // 아이의 인원
      int[] students = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int candy = Integer.parseInt(st.nextToken());
        // 시작 전 홀수개의 사탕을 전부 +1 해서 보충
        students[j] = (candy % 2 == 0 ? candy : candy + 1);
      }

      int count = 0;
      while (!isSameCheck(students)) {

        int preHalf = students[students.length - 1] / 2;

        // 0. 한 반복수
        count++;

        for (int j = 0; j < students.length; j++) {
          // 1. 현재 값의 절반
          int newHalf = students[j] / 2;
          // 2. 변경될 값 저장, 홀수이면 하나 더 추가
          int temp = students[j] - newHalf + preHalf;
          int newValue = temp % 2 == 0 ? temp : temp + 1;
          // 3. 이전 값의 절반값 갱신
          preHalf = newHalf;
          // 4. 배열 최종 업데이트
          students[j] = newValue;
        }
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb);
  }

  private static boolean isSameCheck(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[0]) return false;
    }
    return true;
  }
}