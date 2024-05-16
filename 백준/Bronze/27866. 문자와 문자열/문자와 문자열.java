import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] list = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            list[i] = S.charAt(i)+ "";
        }
        int i = Integer.parseInt(br.readLine());
        System.out.println(list[i-1]);
    }
}

