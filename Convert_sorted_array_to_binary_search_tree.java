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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(num == null || num.length == 0)
			return null;
		return run(num, 0, num.length-1);
    }
	
	public TreeNode run(int[] num, int s, int e)
	{
		if(s == e)
			return new TreeNode(num[s]);
			
		int m = (s+e)/2;
		TreeNode t = new TreeNode(num[m]);
		
		if(m > s)
			t.left = run(num, s, m-1);
		if(m < e)
			t.right = run(num, m+1, e);
		
		return t;
	}
}