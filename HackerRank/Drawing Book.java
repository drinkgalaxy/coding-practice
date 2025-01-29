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
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
    int num = n / 2 + 1; 
    Page[] book = new Page[num];
    book[0] = new Page(0, 1);
    for (int i = 1; i < num; i++) {
        book[i] = new Page(i*2, i*2+1);
    }
    if (n % 2 == 0) {
        book[num-1] = new Page(n, 0);
    }
    
    int front = 0;
    for (int i = 0; i < num; i++) {
        if (book[i].left == p || book[i].right == p) {
            break;
        }
        front++;
    }
    
    int back = 0;
    for (int i = num-1; i >= 0; i--) {
        if (book[i].left == p || book[i].right == p) {
            break;
        }
        back++;
    }

    return Math.min(front, back);
    }
    
    public static class Page {
        int left;
        int right;
        
        public Page(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
