import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(array[i]);
        }

    }
}