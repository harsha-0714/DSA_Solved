/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return root;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0;i<level;i++){
                Node curr = q.poll();
                if(i < level - 1){
                    curr.next = q.peek();
                }else{
                    curr.next = null; 
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }
}