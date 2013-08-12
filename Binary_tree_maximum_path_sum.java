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
	//private static int rmax = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		MyInt rmax = new MyInt(Integer.MIN_VALUE);
		
		recurr(root, rmax);
		
		return rmax.getValue();
    }
	
	public class MyInt {

		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public MyInt(int value) {
			this.value = value;
		}

	}
	
	public int recurr(TreeNode root, MyInt rmax)
	{
		if(root == null)
		{
			return 0;
		}
		
		int pmax = 0;
		int dlc = recurr(root.left, rmax);
		int drc = recurr(root.right, rmax);
		
		pmax = Math.max(root.val, Math.max(root.val+dlc, root.val+drc));
		rmax.setValue(Math.max(rmax.getValue(), Math.max(root.val+dlc+drc, pmax)));
		
		return pmax;
	}
	
}