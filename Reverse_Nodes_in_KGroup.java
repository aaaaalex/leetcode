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
 
 //With ERRORS!!!
 
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(head == null || k == 1)
			return head;
		
		
		ListNode tmp = head;
		int c = 1;
		ListNode currhead = head;
		ListNode newhead = head;
		ListNode newpre = null;
		//ListNode newpost = null;
		boolean first = true;
		while(tmp != null)
		{
			//if(c == 1)
				//currhead = tmp;
			if(c == k)
			{
				ListNode tmphead = tmp;
				ListNode tmptail = tmp.next;
				ListNode tmprs = solve(currhead, tmp);
				if(first)
				{
					newpre = tmprs;
					newpre.next = tmptail;
					newhead = tmphead;
					first = false;
				}
				else
				{
					newpre.next = tmphead;
					newpre = tmprs;
					newpre.next = tmptail;
				}
				tmp = tmptail;
				c = 1;
				currhead = tmp;
			}
			else
			{
				c++;
				tmp = tmp.next;
			}
		}
		
		return newhead;
    }
	
	public static ListNode solve(ListNode head, ListNode tail)
	{
		if(head == tail)
			return head;
		
		/* if(head.next == tail)
		{
			return head;
		} */
		else
		{
			ListNode tmp = solve(head.next, tail);
			tmp.next = head;
			return head;
		}
	}
}