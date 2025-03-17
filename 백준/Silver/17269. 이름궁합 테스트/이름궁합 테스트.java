import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static final int[] STROKES = {
      3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
  };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    String name1 = st.nextToken();
    String name2 = st.nextToken();

    StringBuilder mergedNames = new StringBuilder();
    int minLen = Math.min(N, M);
    int i = 0;

    for (i = 0; i < minLen; i++) {
      mergedNames.append(name1.charAt(i)).append(name2.charAt(i));
      // 이렇게 하면 인덱스 변수 없이 name1과 name2를 순서대로 넣을 수 있음
    }

    if (N > M) { // 이렇게 for문이 끝난 부분부터 사용 가능
      mergedNames.append(name1.substring(i));
    } else if (M > N) {
      mergedNames.append(name2.substring(i));
    }

    int[] nums = new int[mergedNames.length()];
    for (i = 0; i < mergedNames.length(); i++) {
      nums[i] = STROKES[mergedNames.charAt(i) - 'A'];
    }

    nums = sum(nums);

    System.out.println(nums[0] * 10 +nums[1]+"%");

  }

  private static int[] sum(int[] nums) {
    if (nums.length <= 2) {
      return nums;
    }

    int[] newNums = new int[nums.length - 1];
    for (int i = 0; i < newNums.length; i++) {
      // 배열 크기 자체가 -1 이므로 마지막 요소까지 다 처리
      newNums[i] = (nums[i] + nums[i+1]) % 10;
    }

    return sum(newNums);
  }
}
