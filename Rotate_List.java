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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(head == null || n == 0)
			return head;
		
		ListNode tmp = head;
		ListNode start = head;
		ListNode pre = null;
		int c = 1;
		while(tmp.next != null)
		{
			tmp = tmp.next;
			c++;
			if(tmp.next == null)
				pre = start;
			
			if(c > n)
			{
				start = start.next;
			}
		}
		
		if(c <= n)
		{
		    n = n-c;
		    Solution a = new Solution();
		    return a.rotateRight(head, n);  
		}
		
		pre.next = null;
		tmp.next = head;
		return start;
    }
}