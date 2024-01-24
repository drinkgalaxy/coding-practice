
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int result = N/4;
        for (int i = 1; i <= result;i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}