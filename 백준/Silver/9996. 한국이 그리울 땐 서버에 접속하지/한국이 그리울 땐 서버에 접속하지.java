import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    String[] pattern = br.readLine().split("\\*");

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      
      if (line.length() < pattern[0].length() + pattern[1].length()) {
        sb.append("NE").append("\n");
        continue;
      }
      
      String line0 = line.substring(0, pattern[0].length());
      String line1 = line.substring(line.length() - pattern[1].length());

      sb.append(pattern[0].equals(line0) && pattern[1].equals(line1) ? "DA" : "NE").append("\n");
    }
    System.out.println(sb);
  }
}
 