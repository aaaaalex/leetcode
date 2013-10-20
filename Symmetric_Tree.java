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
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //The idea is to do bfs with in-order traverse and then check whether the resulted list is a palindrome or not
		
		return recurSolve(root);
		
    }
	
	public boolean recurSolve(TreeNode root)
	{
		ArrayList<String> vals = new ArrayList<String> ();
		int p = recurun(root, vals);
		int l = vals.size();
		if(l == 0)
			return true;
		
		if(l%2 != 0)
		{
			if((l-1)/2 == p)
			{
				int i = 0;
				int j = vals.size()-1;
				while(i <= j)
				{
					if(!vals.get(i).equals(vals.get(j)))
						return false;
					i++;
					j--;
				}
				return true;
			}
		}

		return false;
	}
	
	public int recurun(TreeNode root, ArrayList<String> vals)
	{
		if(root == null)
			return vals.size();
		if(root.left == null)
			vals.add("#");
		else
			recurun(root.left, vals);
		
		int p = vals.size();
		vals.add((root.val+""));
		
		if(root.right == null)
			vals.add("#");
		else
			recurun(root.right, vals);
		return p;
	}
}