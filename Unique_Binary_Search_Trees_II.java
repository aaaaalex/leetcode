/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		ArrayList<TreeNode> rs = new ArrayList<TreeNode> ();
		if(n == 0)
		{
			rs.add(null);
			return rs;
		}
		for(int i = 0; i < n; i++)
		{
			TreeNode curr = new TreeNode(i);
			int[] r = new int[n+1];
			r[i]--;
			ArrayList<TreeNode> rrs = make(curr, r, false);
			ArrayList<TreeNode> lrs = make(curr, r, true);
			r[i]++;
			for(TreeNode tmpright : rrs)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				if(rrs.size() == 0 && lrs.size() == 0)
					rs.add(new TreeNode(i));
				if(rrs.size() == 0)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				if(lrs.size() == 0)
				{
					for(TreeNode tmpright : rrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						rs.add(tmp);
					}
				}
		}
		
		return rs;
    }
	
	public ArrayList<TreeNode> make(TreeNode curr, int[] r, boolean isLeft)
	{
		ArrayList<TreeNode> rs = new ArrayList<TreeNode> ();
		if(isLeft)
		{
			for(int i = 1; i <= curr.val - 1; i++)
			{
				if(r[i] < 0)
					continue;
				r[i]--;
				ArrayList<TreeNode> lrs = make(new TreeNode(i), r, true);
				ArrayList<TreeNode> rrs = make(new TreeNode(i), r, false);
				r[i]++;
				for(TreeNode tmpright : rrs)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				
				if(rrs.size() == 0 && lrs.size() == 0)
					rs.add(new TreeNode(i));
				if(rrs.size() == 0)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				if(lrs.size() == 0)
				{
					for(TreeNode tmpright : rrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						rs.add(tmp);
					}
				}
			}
			return rs;
		}
		else
		{
			for(int i = curr.val+1; i <= r.length-1; i++)
			{
				if(r[i] < 0)
					continue;
				r[i]--;
				ArrayList<TreeNode> lrs = make(new TreeNode(i), r, true);
				ArrayList<TreeNode> rrs = make(new TreeNode(i), r, false);
				r[i]++;
				for(TreeNode tmpright : rrs)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				if(rrs.size() == 0 && lrs.size() == 0)
					rs.add(new TreeNode(i));
				if(rrs.size() == 0)
				{
					for(TreeNode tmpleft : lrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.left = tmpleft;
						rs.add(tmp);
					}
				}
				if(lrs.size() == 0)
				{
					for(TreeNode tmpright : rrs)
					{
						TreeNode tmp = new TreeNode(i);
						tmp.right = tmpright;
						rs.add(tmp);
					}
				}
			}
			return rs;
		}
	}
	
}