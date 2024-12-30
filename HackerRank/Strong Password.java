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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        int answer = 0;
    
        String numbers = ".*[0-9].*";
        String lowerCase = ".*[a-z].*";
        String upperCase = ".*[A-Z].*";
        String special = ".*[!@#$%^&*()-[+]].*";
        
        boolean isNumbers = Pattern.matches(numbers, password);
        boolean isLowerCase = Pattern.matches(lowerCase, password);
        boolean isUpperCase = Pattern.matches(upperCase, password);
        boolean isSpecial = Pattern.matches(special, password);
        
        if (!isNumbers) {
            answer++;
        }
        
        if (!isLowerCase) {
            answer++;
        }
        
        if (!isUpperCase) {
            answer++;
        }
        
        if (!isSpecial) {
            answer++;
        }
        
        if (n + answer < 6) {
            answer += 6 - (n + answer);
        }
        
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
