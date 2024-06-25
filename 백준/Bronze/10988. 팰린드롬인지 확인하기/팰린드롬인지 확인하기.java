import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArray = new String[str.length()];
        int index = 0;
        for (String s : str.split("")) {
            strArray[index] = s;
            index++;
        }

        int count = 0;
        for (int i = 0; i < strArray.length/2; i++) {
            if (!strArray[i].equals(strArray[(strArray.length-1) - i])) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
