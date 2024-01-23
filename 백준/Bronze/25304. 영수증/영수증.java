import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b;
            count += result;
        }

        if (X == count) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}