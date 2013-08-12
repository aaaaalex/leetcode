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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null)
			return true;
        int result = getHeight(root);
		if(result > -1)
			return true;
		else
			return false;
    }
	public static int getHeight(TreeNode root) {
		if(root.left == null && root.right == null)
			return 0;
		int lh = 0;
		int rh = 0;
		if(root.left != null) {
			int tmp = getHeight(root.left);
			if(tmp == -1)
				return -1;
			lh = tmp +1;
		}
		if(root.right != null) {
			int tmp = getHeight(root.right);
			if(tmp == -1)
				return -1;
			rh = tmp +1;
		}
		
		/* if(rh == -1 || lh == -1)
			return -1; */
		
		if(Math.abs(lh - rh) > 1)
			return -1;
		
		if(rh > lh)
			return rh;
		else
			return lh;
			
	}
}