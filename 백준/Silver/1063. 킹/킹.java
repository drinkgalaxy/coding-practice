import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    String king = st.nextToken(); // 1
    String rock = st.nextToken(); // 2
    int N = Integer.parseInt(st.nextToken());

    int kingX = king.charAt(0) - 'A';
    int kingY = king.charAt(1) - '0' - 1;

    int rockX = rock.charAt(0) - 'A';
    int rockY = rock.charAt(1) - '0' - 1;

    for (int i = 0; i < N; i++) {
      String s = br.readLine(); // 움직여야 할 자리 배정받기

      int[] move = move(s);
      int dx = move[0];
      int dy = move[1];

      int nextKingX = kingX + dx;
      int nextKingY = kingY + dy;

      // 킹이 유효하지 않으면 무시
      if (!isPossible(nextKingX, nextKingY)) continue;

      // 돌과 같은 위치면, 돌도 유효해야 함
      if (nextKingX == rockX && nextKingY == rockY) {
        int nextRockX = rockX + dx;
        int nextRockY = rockY + dy;

        if (!isPossible(nextRockX, nextRockY)) continue;

        // 돌 이동
        rockX = nextRockX;
        rockY = nextRockY;
      }

      // 킹 이동
      kingX = nextKingX;
      kingY = nextKingY;
    }

    System.out.println((char) (kingX + 'A') + "" + (kingY + 1));
    System.out.println((char) (rockX + 'A') + "" + (rockY + 1));
  }

  private static boolean isPossible(int x, int y) {
    return x >= 0 && y >= 0 && x < 8 && y < 8;
  }

  private static int[] move(String s) {
    if (s.equals("R")) {
      return new int[] {1, 0};
    } else if (s.equals("L")) {
      return new int[] {-1, 0};
    } else if (s.equals("B")) {
      return new int[] {0, -1};
    } else if (s.equals("T")) {
      return new int[] {0, 1};
    } else if (s.equals("RT")) {
      return new int[] {1, 1};
    } else if (s.equals("LT")) {
      return new int[] {-1, 1};
    } else if (s.equals("RB")) {
      return new int[] {1, -1};
    } else {
      return new int[] {-1, -1};
    }
  }
}