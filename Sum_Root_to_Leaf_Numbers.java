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
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(root == null)
			return 0;
		return cal(root, 0);
    }
	
	public static int cal(TreeNode root, int curr)
	{
		if(root.right == null && root.left == null)
			return curr*10+root.val;
		
		int r = 0;
		int l = 0;
		
		if(root.right != null)
			r = cal(root.right, curr*10+root.val);
		if(root.left != null)
			l = cal(root.left, curr*10+root.val);
			
		return l+r;
	}
}