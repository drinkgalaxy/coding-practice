import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        int [] arr = new int[number];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int find_number = Integer.parseInt(br.readLine());
        int result = 0;
        for (int j = 0; j < arr.length; j++) {
            if (find_number == arr[j]) {
                result ++;
            }
        }
        System.out.println(result);
    }
}
