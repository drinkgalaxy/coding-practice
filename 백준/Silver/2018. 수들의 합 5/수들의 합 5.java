import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != N) {
            if (sum < N) {
                end_index ++;
                sum += end_index; // end_index 포함이 연속된 자연수의 합(sum) 값 이니까
            } else if (sum > N) {
                sum -= start_index; // start_index를 계속 앞으로 당겨줘야하니까
                start_index ++;
            } else {
                count ++; // 가지수 증가
                end_index ++; // 그리고 다음 단계
                sum += end_index; // 같을 경우 end_index 까지가 연속된 자연수의 합! 끝!
            }
        }
        System.out.println(count);
    }

}
