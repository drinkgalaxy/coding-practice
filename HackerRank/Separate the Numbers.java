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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
    String str = "";
    boolean able = false;

    for (int i = 1; i <= s.length() / 2; i++) {
        str = s.substring(0, i);
        Long firstNumber = Long.parseLong(str);
        
        String validStr = str;
        while (validStr.length() < s.length()) {
            validStr += Long.toString(++firstNumber);
        }
        
        if (validStr.equals(s)) {
            able = true;
            break;
        }
    }
    System.out.println(able ? "YES "+str : "NO");
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
