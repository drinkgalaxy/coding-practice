import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int x_point = sc.nextInt();
        int y_point = sc.nextInt();

        if (x_point > 0) {
            if (y_point > 0) {
                System.out.println(1);
            } else if (y_point < 0){
                System.out.println(4);
            }
        } else if (x_point < 0) {
            if (y_point > 0) {
                System.out.println(2);
            } else if (y_point < 0){
                System.out.println(3);
            }
        }
    }
}