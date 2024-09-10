import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] house;
    static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 집의 개수
        C = Integer.parseInt(st.nextToken()); // 공유기의 개수
        house = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        int min = 1; // 최소 거리
        int max = house[N-1] - house[0] + 1; // 상한값이기 때문에 + 1

        while (min < max) {
            int mid = (min + max) / 2;

            if (canInstall(mid)) {
                min = mid + 1; // 더 넓힐 수 있는지 넓혀보기
            } else {
                max = mid; // 설치 불가하면 좁히기
            }
        }
        System.out.println(min - 1);

    }

    private static boolean canInstall(int distance) {
        int count = 1; // 첫 번째 집에 공유기 설치
        int lastInstalled = house[0]; // 마지막으로 공유기를 설치한 집의 좌표

        for (int i = 1; i < N; i++) {
            // 첫 번째 집에 공유기를 설치한 후 , 그 다음으로 설치할 집을 찾을때
            // mid 이상의 거리를 유지하도록 함.
            if (house[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = house[i]; // 새로운 집에 공유기 설치
            }
        }

        return count >= C;
    }
}
