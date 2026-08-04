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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <=1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(true){
            ListNode temp = curr;
            int cnt = 0;
            while(temp != null && cnt < k){
                temp = temp.next;
                cnt++;
            }
            if(cnt < k){
                break;
            }
            ListNode first = prev;
            ListNode newEnd = curr;
            
            for(int i = 0;i<k && curr != null ;i++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;  
            }
            if(first != null){
                first.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = curr;
            if(curr == null){
                break;
            }
            prev = newEnd;
        }
        
        return head;
    }
}