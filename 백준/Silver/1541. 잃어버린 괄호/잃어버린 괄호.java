import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String equation = br.readLine();
        ArrayList<String> list = new ArrayList<>();

        int result = 0;

        for (String s : equation.split("-")) {
            if (s.contains("+")) {
                int sum = 0;
                for (String str : s.split("[+]")) {
                    sum += Integer.parseInt(str);
                }
                list.add(String.valueOf(sum));
            } else {
                list.add(s);
            }

            result = Integer.parseInt(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                result -= Integer.parseInt(list.get(i));
            }
        }

        System.out.println(result);
    }
}
