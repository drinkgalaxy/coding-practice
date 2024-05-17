import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] voca = new int[26];
        for (int i = 0; i < voca.length; i++) {
            voca[i] = -1;
        }

        String question = br.readLine();
        for (int i = 0; i < question.length(); i++) {
            char ch = question.charAt(i);
            if (voca[ch-'a'] == -1) { // 원소 값이 -1 (처음)인 값만 초기화
                voca[ch-'a'] = i;
            }
        }
        for(int result : voca) {
            System.out.print(result+" ");
        }



    }
}