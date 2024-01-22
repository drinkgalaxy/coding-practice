import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 다 같을 경우
        if (a == b && a == c) {
            System.out.println(10000 + a * 1000);
        // 셋 중 a == b 또는 a == c 둘만 같을 경우
        } else if (a == b && a != c || a == c && a != b) {
            System.out.println(1000 + a * 100);
        // 셋 중 b == c 일 경우
        } else if (b == c && b != a) {
            System.out.println(1000 + b * 100);
        // 다 다를 경우
        } else {
            int max = a;
            if (max < b) {
                max = b;
            } if (max < c) {
                max = c;
            }
            System.out.println(max * 100);
        }
    }
}