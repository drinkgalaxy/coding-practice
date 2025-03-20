import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static char[][] map;
  static boolean[][] check;
  static int n;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();

    n = Integer.parseInt(br.readLine());
    map = new char[5][n/5];
    check = new boolean[5][n/5];

    String cmd = br.readLine();

    int idx = 0;
    for(int i=0; i<5; i++) {
      for(int j=0; j<n/5; j++) {
        char now = cmd.charAt(idx);
        map[i][j] = now;
        idx++;
      }
    }
    int cnt = 0;
    for(int i=0; i<n/5; i++) {
      if(map[0][i]=='#' && !check[0][i]) cnt = bfs(0, i);

      if(cnt==5) answer.append(1);
      else if(cnt==7) answer.append(7);
      else if(cnt==9) answer.append(4);
      else if(cnt==13) answer.append(8);
      else if(cnt==12 || cnt==11)answer.append(search(cnt, i));

      cnt = 0;
    }
    System.out.println(answer.toString());
  }
  static int bfs(int x, int y){
    int cnt = 0;
    Queue<int[]> queue = new LinkedList<>();
    check[x][y] = true;
    queue.add(new int[]{x, y});
    while(!queue.isEmpty()){
      int[] now = queue.poll();
      cnt++;
      for(int i=0; i<4; i++){
        int nx = now[0]+dx[i];
        int ny = now[1]+dy[i];

        if (nx >= 0 && ny >= 0 && nx < 5 && ny < n/5) {
          if (map[nx][ny] == '#' && !check[nx][ny]) {
            queue.add(new int[]{nx, ny});
            check[nx][ny] = true;
          }
        }
      }
    }
    return cnt;
  }
  static int search(int cnt, int start){
    int answer = 0;
    if(cnt==11){
      if(map[3][start]=='#') answer = 2;
      else if(map[1][start]=='#') answer = 5;
      else answer = 3;
    }
    else if(cnt==12){
      if(map[1][start+2]=='.') answer = 6;
      else if(map[3][start]=='.') answer = 9;
      else answer = 0;
    }
    return answer;
  }
}
