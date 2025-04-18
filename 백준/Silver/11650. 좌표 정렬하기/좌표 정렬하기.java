import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    List<Coordinate> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list.add(new Coordinate(x, y));
    }

    Collections.sort(list);

    for (Coordinate coordinate : list) {
      sb.append(coordinate.x).append(" ").append(coordinate.y).append("\n");
    }

    System.out.println(sb);
  }

  private static class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Coordinate other) {
      if (this.x == other.x) {
        return this.y - other.y;
      } else {
        return this.x - other.x;
      }
    }
  }

}