import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    List<Member> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] ques = br.readLine().split(" ");
      list.add(new Member(Integer.parseInt(ques[0]), ques[1], i));
    }

    Collections.sort(list);

    StringBuilder sb = new StringBuilder();
    for (Member member : list) {
      sb.append(member.age).append(" ").append(member.name).append("\n");
    }
    System.out.println(sb);
  }

  private static class Member implements Comparable<Member> {
    int age;
    String name;
    int idx;

    public Member(int age, String name, int idx) {
      this.age = age;
      this.name = name;
      this.idx = idx;
    }

    @Override
    public int compareTo(Member other) {
      if (this.age == other.age) {
        return this.idx - other.idx;
      } else {
        return this.age - other.age;
      }
    }

  }
}