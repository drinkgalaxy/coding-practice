import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine()); // 1m^2 넓이에 자라는 참외의 개수

    int[] directions = new int[6];
    int[] lengths = new int[6];

    for (int i = 0; i < 6; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      directions[i] = Integer.parseInt(st.nextToken());
      lengths[i] = Integer.parseInt(st.nextToken());
    }

    int maxWidth = 0;
    int maxHeight = 0;
    int maxWidthIdx = 0;
    int maxHeightIdx = 0;

    for (int i = 0; i < 6; i++) {
      if (directions[i] == 1 || directions[i] == 2) {
        if (lengths[i] > maxWidth) {
          maxWidth = lengths[i];
          maxWidthIdx = i;
        }
      } else if (directions[i] == 3 || directions[i] == 4) {
        if (lengths[i] > maxHeight) {
          maxHeight = lengths[i];
          maxHeightIdx = i;
        }
      }
    }

    int minWidth = Math.abs(lengths[(maxHeightIdx + 5) % 6] - lengths[(maxHeightIdx + 1) % 6]);
    int minHeight = Math.abs(lengths[(maxWidthIdx + 5) % 6] - lengths[(maxWidthIdx + 1) % 6]);



    System.out.println(((maxWidth * maxHeight) - (minWidth * minHeight)) * K);
  }
}