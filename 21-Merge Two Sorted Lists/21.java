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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode curr1 = list1, prev1 = null, curr2 = list2, prev2 = null;
       ListNode head = null;
       ListNode out = null;
       boolean firstran = false;
       while (curr1 != null && curr2 != null) {
           if (curr1.val > curr2.val) {
               prev2 = curr2;
               curr2 = curr2.next;
               if (firstran) {
                    out.next = new ListNode(prev2.val);
                    out = out.next;
               } else {
                   head = new ListNode(prev2.val);
                    out = head;
                   firstran = true;
               }
               
           } else {
               prev1 = curr1;
               curr1 = curr1.next;
                if (firstran) {
                    out.next = new ListNode(prev1.val);
                    out = out.next;
               } else {
                   head = new ListNode(prev1.val);
                    out = head;
                   firstran = true;
               }
           }
       }
       if (curr1 == null) {
           if (!firstran) {
               return curr2;
           } else {
                out.next = curr2;
           }
           
       } else {
           if (!firstran) {
               return curr1;
           } else {
out.next = curr1;
           }
           
       }
       return head;
    }
}
