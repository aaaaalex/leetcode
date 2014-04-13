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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        check(root, res, 0);
        return res;
    }
    
    public void check(TreeNode root, ArrayList<ArrayList<Integer>> res, int level) {
        if(root == null){
            return;
        }
        ArrayList<Integer> tmpres = null;
        if(res.size() > level){
            tmpres = res.get(level);
        } else {
            tmpres = new ArrayList<Integer> ();
        }
        
        tmpres.add(root.val);
        if(res.size() <= level) {
            res.add(level, tmpres);
        }
        check(root.left, res, level+1);
        check(root.right, res, level+1);
    }
}