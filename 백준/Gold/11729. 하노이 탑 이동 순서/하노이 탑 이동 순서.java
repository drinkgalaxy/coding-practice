import java.io.*;


public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 번째 장대에 쌓인 원판의 개수

        sb.append((int) (Math.pow(2, N) - 1)).append("\n");
        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    /*
     * N : 원판의 개수
     * start : 출발지
     * mid : 옮기기 위해 이동해야 하는 장소
     * to : 목적지
     */
    public static void Hanoi(int N, int start, int mid, int to) {
        // 이동할 원반의 수가 1개
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        // A -> C로 옮겨야 할 때

        // STEP 1) N-1개를 A에서 B로 이동 (start -> mid)
        Hanoi(N - 1, start, to, mid);

        // STEP 2) 1개를 A에서 C로 이동 (start -> to)
        sb.append(start + " " + to + "\n");

        // STEP 3) N-1개를 B에서 C로 이동 (mid -> to)
        Hanoi(N - 1, mid, start, to);
    }
}