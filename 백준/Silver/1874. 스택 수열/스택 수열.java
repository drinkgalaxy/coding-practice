import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 숫자의 개수
        int[] sequence = new int[n]; // 만들어야 할 수열

        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int current = 1; // push할 숫자

        for (int num : sequence) {
            while (current <= num) { // 목표 숫자까지 push
                stack.push(current++);
                result.append("+\n");
            }

            if (stack.peek() == num) { // 목표 숫자 pop
                stack.pop();
                result.append("-\n");
            } else { // pop할 숫자가 스택 top보다 작다면 불가능
                System.out.println("NO");
                return;
            }
        }

        System.out.print(result);
    }
}
