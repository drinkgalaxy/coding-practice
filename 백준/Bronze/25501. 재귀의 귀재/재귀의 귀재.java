
import java.io.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            String S = br.readLine();
            int a = isPalindrome(S);
            System.out.println(a+" "+ count);
        }
    }

    static int recursion(String str, int left, int right) {
        count++;
        if (left >= right) {
            return 1;
        } else if (str.charAt(left) != str.charAt(right)) {
            return 0;
        } else {
            return recursion(str, left+1, right-1);
        }
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }
}