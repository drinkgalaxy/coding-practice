
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        for (int k = 1; k <= n; k++) {
            count += k;
        }
        System.out.println(count);
    }
}