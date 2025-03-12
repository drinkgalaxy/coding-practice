import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] um = br.readLine().split(" ");

    System.out.println(check(um));
  }

  private static String check(String[] um) {
    if (IsAscending(StringToInteger(um))) {
      return "ascending";
    } else if (IsDescending(StringToInteger(um))) {
      return "descending";
    } else {
      return "mixed";
    }
  }

  private static boolean IsAscending(Integer[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] >= arr[i+1]) {
        return false;
      }
    }
    return true;
  }

  private static boolean IsDescending(Integer[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] <= arr[i+1]) {
        return false;
      }
    }
    return true;
  }

  private static Integer[] StringToInteger(String[] um) {
    Integer[] arr = new Integer[um.length];
    int index = 0;
    for (String s : um) {
      arr[index++] = Integer.valueOf(s);
    }
    return arr;
  }
}
