import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static DNA[] dnas;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // DNA 의 수
    int M = Integer.parseInt(st.nextToken()); // 문자열의 길이 M

    dnas = new DNA[M];

    // 인덱스 별 ATGC 클래스 배열을 만들어 (A, T, G, C)
    for (int j = 0; j < dnas.length; j++) {
      dnas[j] = new DNA(0, 0, 0, 0);
    }

    // 문자열을 입력받아
    for (int i = 0; i < N; i++) {
      String dna = br.readLine();

      // 문자열을 입력받을 때 인덱스별 ATGC 개수를 저장해
      for (int j = 0; j < dna.length(); j++) {
        classification(dna.charAt(j), j);
      }
    }

    StringBuilder sb = new StringBuilder();
    int sum = 0;
    // for문을 돌면서 index 별로 가장 큰 ATGC를 꺼내서 저장해
    for (int i = 0; i < dnas.length; i++) {
      sb.append(dnas[i].find());
      sum += (N - dnas[i].max());
    }

    System.out.println(sb);
    System.out.println(sum);

  }

  private static void classification(char c, int index) {
    if (c == 'A') {
      dnas[index].A = dnas[index].A + 1;
    } else if (c == 'T') {
      dnas[index].T = dnas[index].T + 1;
    } else if (c == 'G') {
      dnas[index].G = dnas[index].G + 1;
    } else {
      dnas[index].C = dnas[index].C + 1;
    }
  }

  private static class DNA {
    int A;
    int T;
    int G;
    int C;

    private DNA(int A, int T, int G, int C) {
      this.A = A;
      this.T = T;
      this.G = G;
      this.C = C;
    }

    private int max() {
      return Math.max(Math.max(this.A, this.T), Math.max(this.G, this.C));
    }

    private char find() { // 사전 순 우선순위 고려
      if (A >= T && A >= G && A >= C) return 'A';
      if (C >= A && C >= T && C >= G) return 'C';
      if (G >= A && G >= C && G >= T) return 'G';
      return 'T';
    }
  }
}
