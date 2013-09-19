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
 
 //Not yet finished!!!
 //Should do it in second round
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
			return head;
		
		int c = head.val;
		
		while(head != null)
		{
			if(head.val != c)
			{
				break;
			}
			
			head = head.next;
		}
		
		if(head == null)
			return head;
		
		ListNode tmp = head;
		
		while(tmp.next != null)
		{
			int currVal = tmp.val;
			ListNode tmptmp = tmp.next;
			while(tmptmp.next != null)
			{
				
			}
		}
    }