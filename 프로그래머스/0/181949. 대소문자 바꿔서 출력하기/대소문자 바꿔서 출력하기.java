import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = sc.next();
        for (int i = 0; i < a.length(); i++) {
            char value = a.charAt(i);
            if (Character.isUpperCase(value)) {
                sb.append(Character.toLowerCase(value));
            } else {
                sb.append(Character.toUpperCase(value));
            }
        }
        System.out.println(sb);
    }
}