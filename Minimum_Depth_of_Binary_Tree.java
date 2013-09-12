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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null)
			return 0;
		
		return getMinDepth(root, 1);
    }
	
	public static int getMinDepth(TreeNode root, int depth)
	{
		if(root.left == null && root.right == null)
			return depth;
		if(root.left == null)
			return getMinDepth(root.right, depth+1);
		if(root.right == null)
			return getMinDepth(root.left, depth+1);
			
		return Math.min(getMinDepth(root.left, depth+1), getMinDepth(root.right, depth+1));
		
	}
}