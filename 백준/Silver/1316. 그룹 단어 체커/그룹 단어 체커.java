import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set;
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set = new HashSet<>();
            boolean isGroupWord = true;
            char preChar = 0;
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (currentChar != preChar) {
                    if (set.contains(currentChar)) {
                        isGroupWord = false;
                        break;
                    }
                    set.add(currentChar);
                }
                preChar = currentChar;
            }
            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}