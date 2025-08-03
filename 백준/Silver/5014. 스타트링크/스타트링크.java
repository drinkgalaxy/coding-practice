import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[] button;
  static int F, S, G, U, D;
  static int result = -1;
  static Queue<Integer> queue = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 총 F층
    // S층에서 G층으로 가야 함.
    // U버튼은 위로 U층, D버튼은 아래로 D층
    // G층에 도착하려면 적어도 몇 번?
    //
    StringTokenizer st = new StringTokenizer(br.readLine());
    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    button = new int[F+1];
    for (int i = 1; i <= F; i++) {
      button[i] = -1;
    }

    // 처음 시작은 버튼 안 눌러도 갈 수 있음
    queue.add(S);
    button[S] = 0;
    Bfs();

    if (result == -1) {
      System.out.println("use the stairs");
    } else {
      System.out.println(result);
    }
  }

  private static void Bfs() {

    while (!queue.isEmpty()) {
      Integer value = queue.poll();

      // 방법 찾으면
      if (value == G) {
        result = button[value];
        return;
      }

      // 모든 경로를 고려해야 함

      // 위로 이동
      if (value + U <= F && button[value + U] == -1) {
        queue.add(value + U);
        button[value + U] = button[value] + 1;
      }

      // 아래로 이동
      if (value - D >= 1 && button[value - D] == -1) {
        queue.add(value - D);
        button[value - D] = button[value] + 1;
      }
    }
  }
}