import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Class> queue = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x != 0) {
        queue.offer(new Class(x));
      } else {
        if (queue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(queue.poll());
        }
      }
    }
  }

  private static class Class implements Comparable<Class> {
    int x;
    int lxl;

    public Class(int x) {
      this.x = x;
      this.lxl = Math.abs(x);
    }

    @Override
    public int compareTo(Class c) {
      if (this.lxl == c.lxl) {
        return this.x - c.x;
      } else {
        return this.lxl - c.lxl;
      }
    }

    @Override
    public String toString() {
      return x+"";
    }
  }
}