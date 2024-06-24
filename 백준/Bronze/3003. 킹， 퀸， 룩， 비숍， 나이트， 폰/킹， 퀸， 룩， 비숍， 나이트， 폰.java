import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 비교할 배열
        int[] black = {1, 1, 2, 2, 2, 8};
        int[] white = new int[6];
        List<String> list = new ArrayList<>();
        // 데이터 입력
        String data = br.readLine();
        // 데이터 저장
        for (String s : data.split(" ")) {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            white[i] = Integer.valueOf(list.get(i));
        }
        // 비교 후 count 저장
        for (int i = 0; i < black.length; i++) {
            if (black[i] == white[i]) {
                white[i] = 0;
            } else if (black[i] > white[i]) {
                white[i] = black[i] - white[i];
            } else {
                white[i] = black[i] - white[i];
            }
        }
        for (int i = 0; i < white.length; i++) {
            if (white[i] != white[white.length - 1]) {
                System.out.print(white[i]+" ");
            } else {
                System.out.println(white[i]);
            }
        }

    }
}
