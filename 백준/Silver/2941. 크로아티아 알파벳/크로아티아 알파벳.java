import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    String line = br.readLine();

    for (int i = 0; i < alphabet.length; i++) {
      if (line.contains(alphabet[i])) {
        line = line.replaceAll(alphabet[i], " ");
      }
    }

    System.out.println(line.length());
  }
}
 