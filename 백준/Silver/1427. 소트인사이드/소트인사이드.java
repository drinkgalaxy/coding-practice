import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] array = new int[N.length()];

        for (int i = 0; i < N.length(); i++) {
            array[i] = Integer.parseInt(N.substring(i, i+1));
        }

        for (int i = 0; i < N.length(); i++) {
            int min = i;
            for (int j = i+1; j < N.length(); j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (array[min] < array[i]) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]);
        }
    }
}