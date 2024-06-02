/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return Reverse(root);
    }

    public TreeNode Reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = new TreeNode();
        root.val = root.val;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        Reverse(root.left);
        Reverse(root.right);

        return root;
    }
}
