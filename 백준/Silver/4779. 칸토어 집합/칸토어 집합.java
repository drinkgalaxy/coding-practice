import java.io.*;
import java.util.Arrays;

public class Main {
    static char[] lineArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String input; // 입력 값

        while ((input = br.readLine()) != null) { // 파일의 끝에서 입력을 멈춘다. = 입력값이 없을 때까지 반복
            int N = Integer.parseInt(input);
            sb = new StringBuilder();

            int len = (int) Math.pow(3, N); // 3의 N승

            lineArr = new char[len]; // 3의 N승 크기를 가진 배열
            Arrays.fill(lineArr, '-');

            divide(0, len);

            for (int i = 0; i < lineArr.length; i++) {
                sb.append(lineArr[i]);
            }
            System.out.println(sb);
        }
        br.close();
    }

    static void divide (int start, int length) {
        if (length <= 1) {
            return; // 재귀함수 종료조건 잊지말기
        }

        int newLength = length / 3;

        // 가운데 공백 (두 번째 구역) 으로 바꾸기
        for (int a = start + newLength; a < start + newLength*2; a++) {
            lineArr[a] = ' ';
        }

        // 첫 번째 구역 쪼개기
        divide(start, newLength);

        // 세 번째 구역 쪼개기
        divide(start + newLength*2, newLength);
    }
}
     