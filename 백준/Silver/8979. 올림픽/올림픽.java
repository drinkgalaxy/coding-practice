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

    // 등수는 자신보다 더 잘한 나라 수 + 1
    // 두 나라의 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다.

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 국가의 수
    int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

    List<Node> list = new ArrayList<>();

    // 각 국가를 나타내는 정수와 국가가 얻은 금, 은, 동 메달 수가 주어짐
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int number = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());
      list.add(new Node(number, gold, silver, bronze));
    }

    Collections.sort(list);


    // 정렬 후 동일 순위 관리
    list.get(0).rank = 1;
    for (int i = 1; i < list.size(); i++) {
      Node prev = list.get(i - 1);
      Node now = list.get(i);

      if (now.gold == prev.gold && now.silver == prev.silver && now.bronze == prev.bronze) {
        now.rank = prev.rank;
      } else {
        now.rank = i+1; // 현재 인덱스 + 1 해야함.
      }
    }

    // K 나라의 랭킹 출력
    for (Node node : list) {
      if (node.number == K) {
        System.out.println(node.rank);
        break;
      }
    }

  }

  private static class Node implements Comparable<Node> {
    int number;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Node(int number, int gold, int silver, int bronze) {
      this.number = number;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    @Override
    public int compareTo(Node other) {
      if (this.gold == other.gold && this.silver == other.silver) {
        return other.bronze - this.bronze;
      } else if (this.gold == other.gold) {
        return other.silver - this.silver;
      } else {
        return other.gold - this.gold;
      }
    }
  }
}