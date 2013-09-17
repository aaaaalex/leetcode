/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		solve(root);
    }
	
	public static void solve(TreeLinkNode root)
	{
		if(root == null)
			return;
		
		TreeLinkNode tmp = root;
		
		TreeLinkNode curr = null;
		
		TreeLinkNode linehead = null;
		while(tmp != null)
		{
			if(curr == null)
			{
				if(tmp.left != null)
				{
					curr = tmp.left;
					curr.next = tmp.right;
				}
				else
				{
					if(tmp.right != null)
						curr = tmp.right;
				}
				
				if(curr != null)
				{
					linehead = curr;
					if(curr.next != null)
						curr = curr.next;
				}
			}
			else
			{
				if(tmp.left != null)
				{
					curr.next = tmp.left;
					curr = curr.next;
					curr.next = tmp.right;
				}
				else
				{
					if(tmp.right != null)
					{
						curr.next = tmp.right;
					}
				}
				
				if(curr.next != null)
					curr = curr.next;
				
			}
			
			tmp = tmp.next;
		}
		if(linehead != null)
			solve(linehead);
	}
}