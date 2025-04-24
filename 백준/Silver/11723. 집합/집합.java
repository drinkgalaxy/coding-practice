import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int M = Integer.parseInt(br.readLine());
    int S = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < M; i++) {
      String[] question = new String[2];
      question[0] = br.readLine();
      if (question[0].contains(" ")) {
        int idx = 0;
        for (String s : question[0].split(" ")) {
          question[idx++] = s;
        }
      }

      if (question[0].equals("all")) {
        S = (1 << 21) - 1;
      } else if (question[0].equals("empty")) {
        S = 0;
      } else if (question[0].equals("add")) {
        S |= (1 << Integer.parseInt(question[1]));
      } else if (question[0].equals("remove")) {
        S &= ~(1 << Integer.parseInt(question[1]));
      } else if (question[0].equals("check")) {
        sb.append((S & (1 << Integer.parseInt(question[1]))) != 0 ? 1 : 0).append("\n");
      } else if (question[0].equals("toggle")) {
        S ^= (1 << Integer.parseInt(question[1]));
      }
    }
    System.out.println(sb);
  }
}