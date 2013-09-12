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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode rs = null;
		ListNode result = null;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		while(true)
		{
			if(l1 == null && l2 == null)
				break;
			
			if(l1 == null)
			{
				rs.next = new ListNode(l2.val);
				l2 = l2.next;
				rs = rs.next;
				continue;
			}
			
			if(l2 == null)
			{
				rs.next = new ListNode(l1.val);
				l1 = l1.next;
				rs = rs.next;
				continue;
			}
			
			int v1 = l1.val;
			int v2 = l2.val;
			int min = Integer.MAX_VALUE;
			
			
			if(v1 > v2)
			{
				min = v2;
				l2 = l2.next;
			}
			else
			{
				min = v1;
				l1 = l1.next;
			}
			
			if(rs == null)
			{
				rs = new ListNode(min);
				result = rs;
			}
			else
			{
				rs.next = new ListNode(min);
				rs = rs.next;
			}
		}
		
		return result;
    }
}