import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // tc
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split("");

            int score = 0;
            int count = 0;
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("O")) {
                    count++;
                    score += count;
                } else {
                    count = 0;
                }
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }
}