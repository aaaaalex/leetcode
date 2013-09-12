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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(lists == null || lists.isEmpty())
			return null;
		
		ListNode rs = null;
		ListNode result = null;
		int l = 0;
		while(true)
		{
			boolean c = false;
			int min = Integer.MAX_VALUE;
			//ListNode minNode = new ListNode(0);
			int minPos = 0;
			int i = 0;
			for(ListNode curr : lists)
			{	
				if(curr != null)
				{
					c = true;
					if(curr.val <= min)
					{
						min = curr.val;
						//minNode = curr;
						minPos = i;
					}
				}
				i++;
			}
			
			if(!c)
				break;
			if(l == 0)
			{
				rs = new ListNode(min);
				result = rs;
			}
			else
			{
				rs.next = new ListNode(min);
				rs = rs.next;
			}
			l++;
			lists.set(minPos, lists.get(minPos).next);
		}
		
		return result;
    }
}