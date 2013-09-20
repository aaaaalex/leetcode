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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		ListNode tmp1 = head;
		ListNode tmp2 = head;
		ListNode tmp2pre = null;
		int c = 1;
		
		if(head.next == null)
		{
			if(n == 1)
				return head.next;
		}
		
		while(true)
		{
			tmp1 = tmp1.next;
			c++;
			if(c >= n)
			{	
				if(c == n)
				{
					if((tmp1.next == null || tmp1 == null) && tmp2 == head)
						return tmp2.next;
				}
				if(c > n)
				{
					tmp2pre = tmp2;
					tmp2 = tmp2.next;
				}
			}
			if(tmp1.next == null)
				break;
		}
		
		tmp2pre.next = tmp2.next;
		return head;
    }
}