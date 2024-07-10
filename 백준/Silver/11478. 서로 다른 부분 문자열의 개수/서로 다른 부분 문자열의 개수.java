
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] arr = new String[S.length()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            arr[i] = String.valueOf(S.charAt(i));
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <= arr.length - 1; j++) {
                String newS = S.substring(i, j + 1);
                set.add(newS);
            }
        }

        System.out.println(set.size());
    }
}