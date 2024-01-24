import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트케이스의 개수 T를 입력 받습니다.
        int T = Integer.parseInt(br.readLine());

        // 각 테스트케이스를 처리합니다.
        for (int i = 0; i < T; i++) {
            // A와 B를 입력 받습니다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // A와 B를 더한 결과를 출력합니다.
            int sum = A + B;
            bw.write(Integer.toString(sum));
            bw.newLine();
        }

        // BufferedWriter를 플러시하고 닫습니다.
        bw.flush();
        bw.close();

        // BufferedReader를 닫습니다.
        br.close();
    }
}