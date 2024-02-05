import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 모든 학생들에게 bool 타입으로 false 값 부여 (30명)
        boolean [] students = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            students[n] = true;
        }

        for (int j = 1; j <= 30; j++) {
            if (!students[j]) {
                System.out.println(j);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}