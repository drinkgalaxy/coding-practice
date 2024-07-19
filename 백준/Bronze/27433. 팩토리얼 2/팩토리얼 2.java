
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long answer = 1;
        for (int i = 1; i <= N; i++) {
            answer *= i;
        }
        System.out.println(answer);
    }
}