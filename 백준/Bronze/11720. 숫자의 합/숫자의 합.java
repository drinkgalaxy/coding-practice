import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] result = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(result[i]);
        }
        System.out.println(sum);
    }
}
