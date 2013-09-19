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
		if(head == null)
			return head;
		ListNode currNode = head;
		int curr = 0;
		boolean first = true;
		int l = 1;
		
		while(currNode.next != null)
		{
			if(first)
			{
				curr = currNode.val;
				first = false;
			}
			
			if(curr == currNode.next.val)
			{
				modList(currNode);
			}
			else
			{
				curr = currNode.next.val;
				currNode = currNode.next;
				l++;
			}
		}
		
		return head;
    }
	
	public static void modList(ListNode preTar)
	{
		if(preTar.next != null)
		{
			preTar.next = preTar.next.next;
		}
	}
}