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
		
		ListNode p = head;
		ListNode curr = head;
		
		while(curr != null)
		{
			if(curr.val < x)
			{
				adjust(p, curr);
				p = p.next;
			}
			curr = curr.next;
		}
		
		return head;
    }
	
	public static void adjust(ListNode p, ListNode t)
	{
		int tval = t.val;
		ListNode tmp = p;
		while(tmp != t.next)
		{
			int tt = tmp.val;
			tmp.val = tval;
			tval = tt;
			tmp = tmp.next;
		}
	}
}