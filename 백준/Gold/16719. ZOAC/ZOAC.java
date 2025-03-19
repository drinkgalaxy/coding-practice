import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String text;
  static boolean[] visited;

  static StringBuilder result = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    text = br.readLine();
    visited = new boolean[text.length()];

    zoac(0, text.length() - 1);

    System.out.println(result);

  }

  private static void zoac(int left, int right) {
    if (left > right) return;

    // 현재 문자열에서 가장 작은 문자를 찾는다.
    int idx = left;
    for (int i = idx; i <= right; i++) {
      if (text.charAt(idx) > text.charAt(i)) {
        idx = i;
      }
    }

    // 찾은 가장 작은 문자를 방문처리한다.
    visited[idx] = true;

    // 방문 처리가 되어있는 문자들을 StringBuilder 에 넣는다.
    for (int i = 0; i < visited.length; i++) {
      if (visited[i]) {
        result.append(text.charAt(i));
      }
    }
    result.append("\n");

    // 뒤 -> 앞으로 반복한다.
    zoac(idx + 1, right);
    zoac(left, idx - 1);

  }
}
