import java.io.*;
import java.util.*;

public class Main {
    public static String bigNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        String[] s1Array = s1.split("");
        String[] s2Array = s2.split("");
        for (int i = s1Array.length-1; i >= 0; i--) {
            sb1.append(s1Array[i]);
        }
        for (int i = s2Array.length-1; i >= 0; i--) {
            sb2.append(s2Array[i]);
        }
        String number1 = sb1.toString();
        String number2 = sb2.toString();
        int n1 = Integer.parseInt(number1);
        int n2 = Integer.parseInt(number2);
        if (n1 > n2) {
            bigNumber = Integer.toString(n1);
        } else {
            bigNumber = Integer.toString(n2);
        }
        System.out.println(bigNumber);
    }
}
