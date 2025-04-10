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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    String h = s.substring(0, 2);
    String m = s.substring(3, 5);
    String ss = s.substring(6, 8);
    if (s.substring(s.length()-2, s.length()).equals("PM")) {
        if (!h.equals("12")) {
            return Integer.parseInt(h)+12+":"+m+":"+ss;
        } else {
            return h+":"+m+":"+ss;
        }
        
    } else {
        if (h.equals("12")) {
            return "00:"+m+":"+ss;
        } else {
            return h+":"+m+":"+ss;
        }
    }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
