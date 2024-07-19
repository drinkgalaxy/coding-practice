
import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set;

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            set = new HashSet<>();
            boolean isGroupWord = true;
            char preChar = 0;
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (preChar != currentChar) {
                    if (set.contains(currentChar)) {
                        isGroupWord = false;
                        break;
                    } else {
                        set.add(currentChar);
                    }
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