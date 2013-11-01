/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 //Now it can pass time limit
 //The problem was that have to traverse those ranges that covered by other nodes.
 //So the best way is to define ranges as input parameters into the function.
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<TreeNode> rs = new ArrayList<TreeNode> ();
		if(n == 0)
		{
			rs.add(null);
			return rs;
		}
		
		for(int i = 1; i <= n; i++)
		{
			int[] r = new int[n+1];
			r[i]--;
			ArrayList<TreeNode> tmprs = make(new TreeNode(i), r);
			rs.addAll(tmprs);
		}
		
		return rs;
	}
	
	public ArrayList<TreeNode> make(TreeNode curr, int[] r)
	{
		ArrayList<TreeNode> rs = new ArrayList<TreeNode> ();
		ArrayList<TreeNode> lrs = new ArrayList<TreeNode> ();
		ArrayList<TreeNode> rrs = new ArrayList<TreeNode> ();
		for(int i = curr.val-1; i > 0; i--)
		{
			if(r[i] < 0)
				break;
			r[i]--;
			ArrayList<TreeNode> tmp = make(new TreeNode(i), r);
			r[i]++;
			if(tmp.size() == 0)
				lrs.add(new TreeNode(i));
			else
				lrs.addAll(tmp);
		}
		for(int i = curr.val+1; i<r.length; i++)
		{
			if(r[i] < 0)
				break;
			r[i]--;
			ArrayList<TreeNode> tmp = make(new TreeNode(i), r);
			r[i]++;
			if(tmp.size()==0)
				rrs.add(new TreeNode(i));
			else
				rrs.addAll(tmp);
		}
		
		if(lrs.size() == 0 && rrs.size() == 0)
			rs.add(curr);
		else if(lrs.size()==0)
		{
			for(TreeNode tmpright : rrs)
			{
				TreeNode t = new TreeNode(curr.val);
				t.right = tmpright;
				rs.add(t);
			}
		}
		else if(rrs.size() == 0)
		{
			for(TreeNode tmpleft : lrs)
			{
				TreeNode t = new TreeNode(curr.val);
				t.left = tmpleft;
				rs.add(t);
			}
		}
		else
		{
			for(TreeNode tmpleft : lrs)
			{
				for(TreeNode tmpright : rrs)
				{
					TreeNode t = new TreeNode(curr.val);
					t.right = tmpright;
					t.left = tmpleft;
					rs.add(t);
				}
			}
		}
		return rs;
	}
}