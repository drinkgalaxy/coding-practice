import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static char[][] sky;
  static int[][] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    sky = new char[H][W];
    result = new int[H][W];

    for (int i = 0; i < H; i++) {
      String line = br.readLine();
      for (int j = 0; j < W; j++) {
        sky[i][j] = line.charAt(j);
        if (sky[i][j] == 'c') {
          result[i][j] = 0;
        } else {
          result[i][j] = -1;
        }
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W-1; j++) {
        if (result[i][j] == 0) {
          while (j < W-1) {
            if (result[i][j + 1] == -1) {
              result[i][j + 1] = result[i][j] + 1;
              j++;
            } else {
              break;
            }
          }
        }
      }
    }

    // c가 있는 자리를 기준으로 오른쪽으로 살펴보면서 0 이 아닌 곳은 왼쪽 + 오른쪽 값으로 갱신

    // 처음부터 구름이 떠 있을 때 = 0
    // 구름이 뜨지 않을 때 = -1
    // 처음 구름이 뜨는 분 수 = n

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}