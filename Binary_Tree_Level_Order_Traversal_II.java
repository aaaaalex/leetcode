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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        travel(res, root, 0);
        return res;
    }
    
    public void travel(ArrayList<ArrayList<Integer>> res, TreeNode root, int level) {
        if(root == null)
            return;

        ArrayList<Integer> tmpres = null;
        if((res.size()-level-1) < 0) {
            tmpres = new ArrayList<Integer> ();
        } else {
            tmpres = res.get(res.size()-level-1);
        }
        
        tmpres.add(root.val);
        if((res.size()-level-1) < 0) {
            res.add(0, tmpres);
        }
        
        travel(res, root.left, level+1);
        travel(res, root.right, level+1);
    }
}