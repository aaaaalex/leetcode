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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(k <= 1)
			return head;
		
		ListNode tmp = head;
		ListNode currhead = head;
		ListNode nextPre = head;
		int start = 1;
		int i = 1;
		int c = 1;
		Solution s = new Solution();
		
		while(tmp != null)
		{
			if(c == k)
			{
				//ListNode ttmp = tmp;
				tmp = tmp.next;
				if(start == 1)
				{
					head = s.reverseBetween(currhead, start, i);
				}
				else
				{
					nextPre.next = s.reverseBetween(currhead, 1, c);
				}
				nextPre = currhead;
				currhead = tmp;
				c = 1;
				i++;
				start = i;
			}
			else
			{
				c++;
				i++;
				tmp = tmp.next;
			}
		}
		
		return head;
    }
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 1;
		ListNode tmp = head;
		
		if(head == null)
			return null;
		
		if(m == n)
			return head;
		
		ListNode start = null;
		ListNode end = null;
		ListNode subHead = null;
		ListNode subTail = null;
		ListNode nextnext = tmp.next;
		if(m == 1)
		{
			start = head;
			
			while(tmp != null)
			{
				ListNode next = nextnext;
				if(next != null)
				{
					nextnext = next.next;
				}
				if(i < n)
				{
					next.next = tmp;
					tmp = next;
					i++;
				}
				if(i == n)
				{
					end = tmp;
					if(tmp != null)
					{
						subTail = nextnext;
					}
					break;
				}
			}
			
			start.next = subTail;
			head = end;
			return head;
		}
		else
		{
			while(tmp != null)
			{
				if(i < m)
				{
					if(i == m-1)
						subHead = tmp;
					tmp = tmp.next;
					i++;
					nextnext = nextnext.next;
				}
				ListNode next = nextnext;
				
				if(i >= m && i < n)
				{
					nextnext = next.next;
					next.next = tmp;
					tmp = next;
					i++;
				}
				
				if(i == n)
				{
					end = tmp;
					if(nextnext != null)
					{
						subTail = nextnext;
					}
					break;
				}
				
			}
			
			start = subHead.next;
			subHead.next = end;
			start.next = subTail;
			return head;
		}
    }
}