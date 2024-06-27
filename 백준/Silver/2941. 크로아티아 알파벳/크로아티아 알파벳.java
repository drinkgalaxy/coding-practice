import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> strList = new ArrayList<>();
        for (String str : s.split("")) {
            strList.add(str);
        }

        int count = 0;
        for (int i = 0; i < strList.size(); i++) {
            if (i < strList.size() - 1 && strList.get(i).equals("c") && (strList.get(i + 1).equals("=") || strList.get(i + 1).equals("-"))) {
                count++;
                i++;
            } else if (i < strList.size() - 2 && strList.get(i).equals("d") && strList.get(i + 1).equals("z") && strList.get(i + 2).equals("=")) {
                count++;
                i += 2;
            } else if (i < strList.size() - 1 && strList.get(i).equals("d") && strList.get(i + 1).equals("-")) {
                count++;
                i++;
            } else if (i < strList.size() - 1 && strList.get(i).equals("l") && strList.get(i + 1).equals("j")) {
                count++;
                i++;
            } else if (i < strList.size() - 1 && strList.get(i).equals("n") && strList.get(i + 1).equals("j")) {
                count++;
                i++;
            } else if (i < strList.size() - 1 && strList.get(i).equals("s") && strList.get(i + 1).equals("=")) {
                count++;
                i++;
            } else if (i < strList.size() - 1 && strList.get(i).equals("z") && strList.get(i + 1).equals("=")) {
                count++;
                i++;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}