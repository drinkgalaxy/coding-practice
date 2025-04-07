import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());
    int C = Integer.parseInt(br.readLine());

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= 9; i++) {
      map.put(i, 0);
    }

    String result = String.valueOf(A * B * C);

    for (String s : result.split("")) {
      int i = Integer.parseInt(s);
      map.put(i, map.get(i) + 1);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(map.get(0)).append("\n");
    for (int i = 1; i <= 9; i++) {
      sb.append(map.get(i)).append("\n");
    }
    System.out.println(sb);
  }
}