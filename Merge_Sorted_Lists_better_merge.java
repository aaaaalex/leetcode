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
		return merge(lists);

	}

    public static ListNode merge(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(lists == null || lists.isEmpty())
			return null;
		
		if(lists.size() == 1)
			return lists.get(0);
		
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
				if(i >= 2)
					break;
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
		
		lists.subList(0,2).clear();
		lists.add(0, result);
		
		return merge(lists);
    }
}