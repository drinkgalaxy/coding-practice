import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : str.toLowerCase().split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int maxValue = 0;
        String maxKey = "";
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == maxValue) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("?");
        } else {
            System.out.println(maxKey.toUpperCase());
        }
    }
}
