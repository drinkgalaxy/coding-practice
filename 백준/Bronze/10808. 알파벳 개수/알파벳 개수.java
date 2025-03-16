import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] alphabet = new int[26];

    String question = br.readLine();

    for (int i = 0; i < question.length(); i++) {
      int temp = question.charAt(i) - 'a';
      alphabet[temp]++;
    }

    for (int i : alphabet) {
      System.out.print(i+" ");
    }
  }
}
