/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode node = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return PreOrder(original, cloned, target);
    }

    public TreeNode PreOrder(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            node = cloned;
        }
        PreOrder(original.left, cloned.left, target);
        PreOrder(original.right, cloned.right, target);
        return node;

    }
}
