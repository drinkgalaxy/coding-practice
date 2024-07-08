
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            // 입력받은 값의 첫 번째 문자열이 1~9에 해당하는지 확인
            if (49 <= s.charAt(0) && s.charAt(0) <= 57) {
                int key = Integer.parseInt(s);
                sb.append(map1.get(key));
            } else {
                sb.append(map2.get(s));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}