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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		return solve(root, sum);
    }
	
	public static boolean solve(TreeNode root, int sum)
	{
		if(root == null)
			return false;
			
		if(root.left == null && root.right == null)
		{
			if(sum == root.val)
				return true;
			else
				return false;
		}
		
		return (solve(root.left, sum - root.val) || solve(root.right, sum - root.val));
	}
}