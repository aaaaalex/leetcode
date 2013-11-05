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
	class ResultSet {
		int max;
		int min;
		boolean isValid;
		public ResultSet()
		{
			this.isValid = false;
		}
	}

    public boolean isValidBST(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // The idea is to do preorder traverse in a given tree and return results in the ResultSet
		if(root == null)
			return true;
		ResultSet rs = check(root);
		return rs.isValid;
	}
	
	public ResultSet check(TreeNode root)
	{
		ResultSet lrs = null;
		ResultSet rrs = null;
		ResultSet rs = new ResultSet();
		if(root.left != null)
			lrs = check(root.left);
		if(root.right != null)
			rrs = check(root.right);
	
		if((lrs != null && lrs.isValid != true) || (rrs != null && rrs.isValid != true))
		{
			return rs;
		}
		
		if(lrs != null)
		{
			if(lrs.max >= root.val)
			{
				return rs;
			}
			else
				rs.min = lrs.min;
		}
		else
		{
			rs.min = root.val;
		}
		
		if(rrs != null)
		{
			if(rrs.min <= root.val)
			{
				return rs;
			}
			else
				rs.max = rrs.max;
		}
		else
		{
			rs.max = root.val;
		}
		rs.isValid = true;
		return rs;
	}
}