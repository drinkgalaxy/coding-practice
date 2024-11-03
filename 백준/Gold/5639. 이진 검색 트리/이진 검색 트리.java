import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            root.Insert(Integer.parseInt(input));
        }

        postOrder(root);

        System.out.println(sb);
    }

    static void postOrder(Node n) {
        if (n == null) {
            return;
        }

        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.num).append("\n");
    }

    static class Node {
        int num;
        Node left, right;

        Node (int num) {
            this.num = num;
        }

        void Insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.Insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.Insert(n);
                }
            }
        }
    }
}