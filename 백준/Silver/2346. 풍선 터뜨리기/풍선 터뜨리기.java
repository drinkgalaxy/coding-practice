
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Balloon> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] balloonValue = new int[N];
        for (int i = 0; i < N; i++) {
            balloonValue[i] = Integer.parseInt(st.nextToken()); // 값 저장
        }

        sb.append("1 "); // 무조건 첫번째 풍선 먼저 터트림
        int moveValue = balloonValue[0]; // 이동 값

        for (int i = 1; i < N; i++) {
            // 처음 풍선은 이미 터트렸기 때문에 넣어주지 않음
            deque.add(new Balloon(i+1, balloonValue[i]));
        }

        while (!deque.isEmpty()) {
            // 양수일 경우 인덱스가 큰 쪽으로
            if (moveValue > 0) {
                // 앞에 있는 요소를 모두 뒤로 보낸다.
                for (int i = 1; i < moveValue; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                // 모두 뒤로 보냈다면
                Balloon next = deque.pollFirst();
                moveValue = next.numValue; // 이동값 갱신
                sb.append(next.index+" "); // 터트린 풍선의 위치값 저장
            // 음수일 경우 인덱스가 작은 쪽으로
            } else {
                // 뒤에 있는 요소를 모두 앞으로 보낸다.
                for (int i = 1; i < -moveValue; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                // 모두 앞으로 보냈다면
                Balloon next = deque.pollLast();
                moveValue = next.numValue;
                sb.append(next.index+" ");
            }
        }
        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int numValue;

        public Balloon(int index, int numValue) {
            this.index = index;
            this.numValue = numValue;
        }
    }
}