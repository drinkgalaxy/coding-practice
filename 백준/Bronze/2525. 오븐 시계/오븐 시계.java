import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();
        int time = sc.nextInt();
        int total = (H * 60) + M + time;

        H = total / 60;
        M = total % 60;

        if (H > 23) {
            H = H - 24;
        }
        System.out.println(H +" "+ M);

    }
}