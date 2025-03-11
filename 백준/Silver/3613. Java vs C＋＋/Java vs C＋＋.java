import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    if (isInvalid(s)) {
      System.out.println("Error!");
      return;
    }

    if (s.contains("_")) {
      System.out.println(convertCppToJava(s));
    } else {
      System.out.println(convertJavaToCpp(s));
    }
  }

  private static boolean isInvalid(String s) {
    if (s.endsWith("_")) return true; // _로 시작 x

    if (s.startsWith("_")) return true; // _로 끝남 x

    if (s.contains("__")) return true; // __ 두 개 이상 x

    if (s.contains("_") && !s.equals(s.toLowerCase())) return true; // _가 있는데 대문자 포함 x

    if (Character.isUpperCase(s.charAt(0))) return true; // 대문자로 시작 x

    return false;
  }

  private static String convertCppToJava(String s) {
    StringBuilder sb = new StringBuilder();
    String[] cpp = s.split("_");
    sb.append(cpp[0]);
    for (int i = 1; i < cpp.length; i++) {
      sb.append(Character.toUpperCase(cpp[i].charAt(0)));
      sb.append(cpp[i].substring(1));
    }
    return sb.toString();
  }

  private static String convertJavaToCpp(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        sb.append("_").append(s.toLowerCase().charAt(i));
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
