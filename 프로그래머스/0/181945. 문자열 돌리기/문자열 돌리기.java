import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (String s : str.split("")) {
            System.out.println(s);
        }
    }
}