import java.io.*;
import java.util.Arrays;


public class Main {
    static char[] lineArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb = new StringBuilder();

            int line = (int) Math.pow(3, N);
            lineArr = new char[line];
            Arrays.fill(lineArr, '-');

            divide(0, line);

            for (int i = 0; i < lineArr.length; i++) {
                sb.append(lineArr[i]);
            }
            System.out.println(sb);
        }
        br.close();
    }

    public static void divide(int start, int line) {
        if (line <= 1) {
            return;
        }
        // 0, 27
        int length = line / 3; // 9

        // 가운데 공백으로 바꾸기 9, 18
        for (int i = start + length; i < start + length*2; i++) {
            lineArr[i] = ' ';
        }

        // 첫 번째 구역 나누기. 시작 : 0, 길이 : 9
        divide(start, length);

        // 세 번째 구역 나누기. 시작 : 18, 길이 : 9
        divide(start + length * 2, length);

    }
}
