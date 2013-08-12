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
	//private HashMap<TreeNode, int> dvalueMap = new HashMap<TreeNode, int> new ();
	//private HashMap<TreeNode, int> rvalueMap = new HashMap<TreeNode, int> new();
	private static int rmax = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		recurr(root);
		
		return Solution.rmax;
    }
	
	public int recurr(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		int pmax = 0;
		int dlc = recurr(root.left);
		int drc = recurr(root.right);
		
		pmax = Math.max(root.val, Math.max(root.val+dlc, root.val+drc));
		Solution.rmax = Math.max(Solution.rmax, Math.max(root.val+dlc+drc, pmax));
		
		return pmax;
	}
	
}