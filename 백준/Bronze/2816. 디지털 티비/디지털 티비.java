import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String[] channels;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    channels = new String[N];

    for (int i = 0; i < N; i++) {
      channels[i] = br.readLine();
    }

    StringBuilder result = new StringBuilder();

    // KBS1 찾기
    int index = 0;

    while (!channels[index].equals("KBS1")) {
      index++;
      result.append(1);
    }

    // KBS1 맨 위로 올리기
    while (index > 0) {
      swap(index, index-1);
      index--;
      result.append(4);
    }

    // KBS2 찾기
    while (!channels[index].equals("KBS2")) {
      index++;
      result.append(1);
    }

    // KBS2 맨 위로 올리기 (KBS1의 아래)
    while (index > 1) {
      swap(index, index-1);
      index--;
      result.append(4);
    }

    System.out.println(result);
  }

  private static void swap(int a, int b) {
    String tmp = channels[a];
    channels[a] = channels[b];
    channels[b] = tmp;
  }
}
