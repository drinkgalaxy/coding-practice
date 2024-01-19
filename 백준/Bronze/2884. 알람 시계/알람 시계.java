import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        if (M >= 45) {
            M = M - 45;
        } else if (M < 45) {
            if (H == 0) {
                H = 23;
            } else {
                H = H - 1;
            }
            M = M + 15;
        }
        System.out.println(H+" "+M);
    }
}