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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = new ListNode(0);
		ListNode tmp = result;
		ListNode tail;
		int next = 0;
		int count = 0;
		while(l1 != null || l2 != null){
			int v1 = (l1 != null ? (int)l1.val : 0);
			int v2 = (l2 != null ? (int)l2.val : 0);
			int sum = v1 + v2 + next;
			if(sum >= 10) {
				sum = sum - 10;
				next = 1;
			} else {
				next = 0;
			}
			l1 = (l1 != null ? l1.next : null);
			l2 = (l2 != null ? l2.next : null);
			if(count == 0){
				result.val = sum;
				count++;	
			} else {
				ListNode t = new ListNode(sum);
				tmp.next = t;
				tmp = tmp.next;
			} 
		}
		if(next == 1){
			ListNode t = new ListNode(1);
			
			tmp.next = t;
		}
		return result;
    }
}