import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] distance = new int[n+1][n+1];
    final int INF = 987654321;

    // 인접 행렬 초기화
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          distance[i][j] = 0;
        } else {
          distance[i][j] = INF;
        }
      }
    }

    for (int i = 1; i <= m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (distance[a][b] > c) {
        distance[a][b] = c;
      }
    }

    // 플로이드 워셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (distance[i][j] > distance[i][k] + distance[k][j]) {
            distance[i][j] = distance[i][k] + distance[k][j];
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (distance[i][j] == INF) {
          sb.append(0).append(" ");
        } else {
          sb.append(distance[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
