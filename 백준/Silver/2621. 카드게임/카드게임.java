import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static String[] colors;
  static int[] numbers;
  static Map<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 색깔: R, B, Y, G
    // 숫자: 1 ~ 9
    // 카드: 5장 주어짐

    colors = new String[5];
    numbers = new int[5];

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      colors[i] = st.nextToken();
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    // 숫자별 개수 세기
    map = new HashMap<>();
    for (int number : numbers) {
      map.put(number, map.getOrDefault(number, 0) + 1);
    }

    int score = 0;

    // 조건 분기 시작
    if (isAllSameColor() && isNumberConsecutive()) {
      // 1
      score += numbers[4] + 900;
    } else if (findSameCount(4) != 0) {
      // 2
      score += findSameCount(4) + 800;
    } else if (findSameCount(3) != 0 && findSameCount(2) != 0) {
      // 3
      score += findSameCount(3) * 10 + findSameCount(2) + 700;
    } else if (isAllSameColor()) {
      // 4
      score += numbers[4] + 600;
    } else if (isNumberConsecutive()) {
      // 5
      score += numbers[4] + 500;
    } else if (findSameCount(3) != 0) {
      // 6
      score += findSameCount(3) + 400;
    } else if (findTwoPairs() != null) {
      // 7
      int[] pairs = findTwoPairs();
      score += pairs[1] * 10 + pairs[0] + 300;
    } else if (findSameCount(2) != 0) {
      // 8
      score += findSameCount(2) + 200;
    } else {
      // 9
      score += numbers[4] + 100;
    }

    System.out.println(score);
  }

  private static int findSameCount(int num) {
    int value = Integer.MIN_VALUE;
    for (Integer key : map.keySet()) {
      if (map.get(key) == num) { // 해당 키에 저장된 숫자가 num 과 같을 경우
        value = Math.max(value, key);
      }
    }
    return value == Integer.MIN_VALUE ? 0 : value;
  }

  private static int[] findTwoPairs() {
    int[] pairs = new int[2];
    int idx = 0;

    for (Integer key : map.keySet()) {
      if (map.get(key) == 2) {
        pairs[idx++] = key;
        if (idx == 2) break;
      }
    }

    if (idx < 2) {
      return null; // 두 쌍이 아닐 경우
    }

    Arrays.sort(pairs);
    return pairs;
  }

  private static boolean isAllSameColor() {
    String s = colors[0];
    for (String color : colors) {
      if (!s.equals(color)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isNumberConsecutive() {
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] + 1 != numbers[i + 1]) {
        return false;
      }
    }
    return true;
  }
}