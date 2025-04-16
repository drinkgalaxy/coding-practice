import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
      int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
      int N = Integer.parseInt(st.nextToken()); // 손님

      boolean[][] hotel = new boolean[W][H];

      int count = 0;
      for (int j = 0; j < hotel.length; j++) {
        for (int k = 0; k < hotel[j].length; k++) {
          if (!hotel[j][k]) {
            count++;
            hotel[j][k] = true;
            if (count == N) {
              if (j+1 <= 9) {
                sb.append(k+1).append("0").append(j+1).append("\n");
              } else {
                sb.append(k+1).append(j+1).append("\n");
              }
            }
          }
        }
      }
    }

    System.out.println(sb);
  }
}