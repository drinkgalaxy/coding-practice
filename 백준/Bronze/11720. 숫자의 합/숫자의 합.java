import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] result = new String[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.charAt(i)+"";
        }
        int sum = 0;
        long[] resultByLong = new long[N];
        for (int i = 0; i < resultByLong.length; i++) {
            resultByLong[i] = Long.parseLong(result[i]);
            sum += resultByLong[i];
        }
        System.out.println(sum);
    }
}

