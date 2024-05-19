import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String[] sentenceArray = sentence.split(" ");
        int count = 0;
        for (int i = 0; i < sentenceArray.length; i++) {
            if (!sentenceArray[i].isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}