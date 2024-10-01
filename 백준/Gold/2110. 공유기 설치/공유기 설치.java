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
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int min = 1;
        int max = house[N-1] - house[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            if (canInstall(mid)) {
                min = mid+1;
            } else {
                max = mid;
            }
        }
        System.out.println(min-1);
    }

    private static boolean canInstall(int mid) {
        int count = 1;
        int lastInstalled = house[0]; // 첫 번째 집에 공유기 반드시 설치

        for (int i = 1; i < N; i++) {
            int nextInstalled = house[i];
            if (nextInstalled - lastInstalled >= mid) {
                count++;
                lastInstalled = nextInstalled;
            }
        }

        return count >= C;
    }
}