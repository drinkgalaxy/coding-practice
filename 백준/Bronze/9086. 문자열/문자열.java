import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine(); 
            String[] list = new String[str.length()]; 
            for (int j = 0; j < str.length(); j++) {
                list[j] = str.charAt(j)+"";
            }
            System.out.println(list[0]+list[list.length-1]);
        }
    }
}

