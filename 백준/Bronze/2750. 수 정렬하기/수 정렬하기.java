import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i]; // 값을 미리 저장
            int j = i-1; // 자기보다 1칸 작은 수부터 비교를 시작함
            while(j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--; // 선택할 원소를 삽입할 위치를 찾기위해 j--
            }
            array[j+1] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
