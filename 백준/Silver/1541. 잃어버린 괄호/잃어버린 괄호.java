import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] minus = line.split("-");
        for (int i = 0; i < minus.length; i++) {
            int temp = mySum(minus[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }

    public static int mySum(String A) {
        int sum = 0;
        String[] plus = (A.split("[+]"));
        for (int i = 0; i < plus.length; i++) {
            int temp = Integer.parseInt(plus[i]);
            sum += temp;
        }
        return sum;
    }
}