import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    char[][] room = new char[N][N];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        room[i][j] = line.charAt(j);
      }
    }

    int row = 0;
    for (int i = 0; i < room.length; i++) {
      int count = 0;
      for (int j = 0; j < room[0].length; j++) {
        if (room[i][j] == '.') {
          count++;
        } else {
          count = 0;
        }

        if (count == 2) {
          row++;
        }
      }
    }

    int col = 0;
    for (int i = 0; i < room.length; i++) {
      int count = 0;
      for (int j = 0; j < room[0].length; j++) {
        if (room[j][i] == '.') {
          count++;
        } else {
          count = 0;
        }

        if (count == 2) {
          col++;
        }
      }
    }

    System.out.println(row + " " + col);
  }
}
