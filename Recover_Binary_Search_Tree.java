/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //The idea is to check every pair of left_child => root => right_child
 //The key is that only one pair of nodes got swapped. So there should be at most of two pairs of anormal cases. And one pair is > and the other is < (both anromal)
 //So just need to find out these two pairs and just swap
public class Solution {
	static TreeNode pre;
	static ArrayList<TreeNode> tank;  //Used to save pairs with problems

    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre = null;
		tank = new ArrayList<TreeNode> ();
		inorder(root);
		int tmp = tank.get(tank.size()-1).val;		
		tank.get(tank.size()-1).val = tank.get(0).val;
		tank.get(0).val = tmp;
    }
	
	public static void inorder(TreeNode root)
	{
		if(root == null)
			return;
		inorder(root.left);
		if(pre != null && pre.val > root.val)
		{
			tank.add(pre);
			tank.add(root);
		}
		pre = root;
		inorder(root.right);
	}
}