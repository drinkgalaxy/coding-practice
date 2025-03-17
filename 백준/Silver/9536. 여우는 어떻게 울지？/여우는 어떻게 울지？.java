import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  static String end = "what does the fox say?";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String[] record = br.readLine().split(" ");
      Set<String> set = new HashSet<>();
      String animalType = "";

      while (!(animalType = br.readLine()).equals(end)) {
        set.add(animalType.split(" goes ")[1]);
      }

      StringBuilder sb = new StringBuilder();
      for (String sound : record) {
        if (!set.contains(sound)) {
          sb.append(sound).append(" ");
        }
      }

      System.out.println(sb.toString().trim());
    }

  }
}
