import java.io.*;

public class Main {
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
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

    static class Node {
        int num;
        Node left, right;

        Node (int num) {
            this.num = num;
        }
        Node (int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
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
