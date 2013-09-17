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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return solve(root, sum);
    }
	
	public static ArrayList<ArrayList<Integer>> solve (TreeNode root, int sum)
	{
		if(root == null)
			return new ArrayList<ArrayList<Integer>> ();
	
		if(root.right == null && root.left == null)
		{
			if(root.val == sum)
			{
				ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
				ArrayList<Integer> r = new ArrayList<Integer> ();
				r.add(root.val);
				rs.add(r);
				return rs;
			}
			else
				return new ArrayList<ArrayList<Integer>> ();
		}
		
		ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>> ();
		/* 
		ArrayList<ArrayList<Integer>> rl = solve(root.left, sum - root.val);
		ArrayList<ArrayList<Integer>> rr = solve(root.right, sum - root.val); */
		
		rs.addAll(solve(root.left, sum-root.val));
		rs.addAll(solve(root.right, sum-root.val));
		
		for(ArrayList<Integer> t : rs)
		{
			t.add(0, root.val);
		}
		
		return rs;
	}
}