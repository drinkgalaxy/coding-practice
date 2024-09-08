import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    static int[] answer;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 상근이가 가진 숫자 카드 개수
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 상근이 배열 정렬
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine()); // 비교 카드들 M개

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(" ");
        }

        System.out.println(sb);
    }
    public static int lowerBound(int target) {
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // 중복 원소일 경우 왼쪽으로 탐색해야하므로 내림.
            if (target <= cards[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int upperBound(int target) {
        int lo = 0;
        int hi = cards.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // 중복 원소 보다 큰 값이 상한값임.
            if (target < cards[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
