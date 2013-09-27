/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return solve(p, q);
    }
	
	public static boolean solve(TreeNode p, TreeNode q)
	{
		if(p == null && q == null)
			return true;
		if((p ==  null && q != null)||(p != null && q == null))
			return false;
		
		if(p.val == q.val)
			return solve(p.left, q.left)&&solve(p.right, q.right);
		else
			return false;
	}
}