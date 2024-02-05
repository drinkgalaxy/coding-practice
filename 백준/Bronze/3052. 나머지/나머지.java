import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int [10];
        boolean bl; // n번째와 n+1번째를 비교하기 위한 변수
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        }
        for (int i = 0; i < 10; i++) {
            bl = false; // 기본값을 false로 설정
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    bl = true;
                    break;
                }
            }
            if (bl == false) {
                count ++;
            }
        }
        System.out.println(count);

        bw.flush();
        bw.close();
        br.close();
    }

}
