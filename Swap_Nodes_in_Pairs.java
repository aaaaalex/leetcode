/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null)
			return head;
		
		ListNode curr = head;
		ListNode newHead = null;
		ListNode pre = null;
		
		while(curr.next != null)
		{
			ListNode tmp = curr.next;
			curr.next = tmp.next;
			tmp.next = curr;
			if(pre != null)
				pre.next = tmp;
			pre = curr;
			if(newHead == null)
				newHead = tmp;
			curr = curr.next;
			if(curr == null)
				break;
		}
		
		if(newHead == null)
			newHead = head;
		return newHead;
    }
}