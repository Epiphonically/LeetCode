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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Integer> found = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!found.containsKey(nums[i])) {
                found.put(nums[i],1);
            }
        }
        ListNode out = head;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (found.containsKey(curr.val)) {
                if (prev == null) {
                    curr = curr.next;
                    out = curr;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
                
            } else {
                prev = curr;
              curr = curr.next;
            }
        } 
        return out;
    }
}
