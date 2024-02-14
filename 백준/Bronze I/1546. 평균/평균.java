import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int subject = Integer.parseInt(br.readLine());
        double[] scores = new double [subject];
        // 세준이의 현재 성적 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < subject; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(scores);
        // 최대값 구하기
        double maxValue = scores[scores.length-1];
        for (int i = 0; i < subject; i++) {
            scores[i] = scores[i] / maxValue * 100;
        }
        // 평균 구하기
        System.out.println(Arrays.stream(scores).average().orElse(0));

        bw.flush();
        bw.close();
        br.close();
    }
}
