
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Long> map = new HashMap<>();
        long N = Long.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long key = Long.valueOf(st.nextToken());
            map.put(key, map.getOrDefault(key, Long.valueOf(0)) + 1);
        }

        long M = Long.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long key = Long.valueOf(st.nextToken());
            sb.append(map.getOrDefault(key, Long.valueOf(0))).append(" ");
        }

        System.out.println(sb);
    }
}