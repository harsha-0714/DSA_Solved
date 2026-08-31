/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f = -1;
        int l = -1;
        int min = Integer.MAX_VALUE;
        int pos = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null && curr.next != null){
            boolean isValid = (curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val);
            if(isValid){
                if(f == -1){
                    f = pos;
                }else{
                    min = Math.min(min,pos-l);
                }
                l = pos;
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if(f == -1 || f == l){
            return new int[]{-1,-1};
        }
        int max = l - f;
        return new int[]{min,max};
    }
}