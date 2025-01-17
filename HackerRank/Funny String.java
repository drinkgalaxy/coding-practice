import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'funnyString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String funnyString(String s) {
    // Write your code here

    int[] s1 = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
        s1[i] = (int) s.charAt(i);
    }
    
    StringBuilder sb = new StringBuilder();
    sb.append(s).reverse();
    int[] s2 = new int[s.length()];
    for (int i = 0; i < sb.toString().length(); i++) {
        s2[i] = (int) sb.toString().charAt(i);
    }
    
    String sb1 = "";
    for (int i = 1; i < s1.length; i++) {
        sb1 += Math.abs(s1[i] - s1[i-1]);
    }
    
    String sb2 = "";
    for (int i = 1; i < s2.length; i++) {
        sb2 += Math.abs(s2[i] - s2[i-1]);
    }
    
    if (sb1.equals(sb2)) {
        return "Funny";
    } else {
        return "Not Funny";
    }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
