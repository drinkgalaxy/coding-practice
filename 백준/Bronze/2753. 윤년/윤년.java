import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner 선언
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        boolean yoon = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        if (yoon == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}