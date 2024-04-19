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
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while(j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp; // 찾은 위치에 값을 삽입한다.
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
