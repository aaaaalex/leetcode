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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode r = null;
		ListNode r2 = null;
		
		ListNode f = null; // front list
		ListNode b = null; // behind list
		
		ListNode curr = head;
		while(curr != null)
		{
			if(curr.val < x)
			{
				if(f == null)
				{
					f = new ListNode(curr.val);
					r = f;
				}
				else
				{
					f.next = new ListNode(curr.val);
					f = f.next;
				}
			}
			else
			{
				if(b == null)
				{
					b = new ListNode(curr.val);
					r2 = b;
				}
				else
				{
					b.next = new ListNode(curr.val);
					b = b.next;
				}
			}
			curr = curr.next;
		}
		if(r == null)
			return r2;
		f.next = r2;
		return r;
		
	}
}