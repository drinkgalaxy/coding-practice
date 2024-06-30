import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a1 = Integer.parseInt(st.nextToken());
        long a2 = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(br.readLine());
        long n = Integer.parseInt(br.readLine());
        long f = (a1 * n) + a2;
        if (f <= c * n && c >= a1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}