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
    int res = 0;
    private int[] treeAvg(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] l = treeAvg(root.left);
        int[] r = treeAvg(root.right);
        int val = l[0] + r[0] + root.val;
        int cnt = l[1] + r[1] + 1;
        if(root.val == val/cnt){
            res++;
        }
        return new int[]{val,cnt};
    }
    public int averageOfSubtree(TreeNode root) {
        treeAvg(root);
        return res;
    }
}