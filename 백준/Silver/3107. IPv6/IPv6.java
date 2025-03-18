import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static final String ZERO_GROUP = "0000";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String ques = br.readLine();

    String[] arr = new String[8]; // 불변 길이기 때문에 8로
    String[] parts = ques.split(":", -1); // -1을 주면 빈 문자열도 유지
    int index = 0;
    boolean expanded = false;

    for (int i = 0; i < parts.length; i++) {
      if (parts[i].isEmpty() && !expanded) { // ::의 위치이면
        int groups = 8 - (parts.length - 1); // 채워야하는 그룹
        if (ques.startsWith("::")) groups++;
        if (ques.endsWith("::")) groups++;
        for (int j = 0; j < groups; j++) {
          arr[index++] = ZERO_GROUP;
        }
        expanded = true;
      } else if (!parts[i].isEmpty()) {
        arr[index++] = zeroFill(parts[i]);
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      result.append(arr[i]);
      if (i != arr.length - 1) {
        result.append(":");
      }
    }

    System.out.println(result);
  }

  private static String zeroFill(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length(); i < 4; i++) {
      sb.append("0");
    }
    sb.append(s);
    return sb.toString();
  }

}
