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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = find(root,x);
        TreeNode yNode = find(root,y);
        int xLevel = level(root,xNode , 0);
        int yLevel = level(root,yNode,0);
        return (xLevel == yLevel && (!isSibling(root,xNode,yNode)));

    }
    public TreeNode find(TreeNode root , int x){
        if(root == null){
            return null;
        }
        if(root.val == x){
            return root;
        }
        TreeNode l = find(root.left , x);
        if(l != null){
            return l;
        }
        return find(root.right , x);
    }
    public int level(TreeNode root,TreeNode x , int level){
        if(root == null){
            return 0;
        }
        if(root == x){
            return level;
        }
        int l = level(root.left ,x,level+1);
        if(l != 0){
            return l;
        }
        return level(root.right , x ,level + 1);
    }
    public boolean isSibling(TreeNode root , TreeNode x , TreeNode y){
        if(root == null){
            return false;
        }
        return (root.left == x  && root.right == y) || (root.left == y && root.right == x) || isSibling(root.left , x , y) || isSibling(root.right , x , y);
    }
}