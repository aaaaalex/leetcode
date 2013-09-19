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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return solve(head);
    }
	
	public static ListNode solve(ListNode curr)
	{
		if(curr == null)
			return null;
		
		if(curr.next == null)
			return curr;
		
		if(curr.next.val != curr.val)
		{
			curr.next = solve(curr.next);
			return curr;
		}
		ListNode tmp = curr;
		int currVal = curr.val;
		while(tmp != null)
		{
			if(tmp.val != currVal)
			{
				break;
			}
			tmp = tmp.next;
		}
		
		return solve(tmp);
	}
}