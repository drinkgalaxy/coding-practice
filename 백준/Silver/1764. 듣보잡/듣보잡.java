
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        int count = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 2) {
                count++;
                list.add(s);
            }
        }

        Collections.sort(list);
        
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}