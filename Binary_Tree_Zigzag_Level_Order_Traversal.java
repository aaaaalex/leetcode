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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> res = new ArrayList<ArrayList<TreeNode>>();
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if(root == null)
            return result;
        boolean isLeft = false;
        int currLevel = 0;
        int i = 0;
        ArrayList<TreeNode> tmp = new ArrayList<TreeNode> ();
        tmp.add(root);
        res.add(tmp);
        int size = tmp.size();
        while(i<size) {
            ArrayList<TreeNode> tmpres = res.get(currLevel);
            TreeNode r = tmpres.get(size-1-i);
            ArrayList<TreeNode> nextLevel = null;
            if(res.size() > (currLevel+1)) {
                nextLevel = res.get(currLevel+1);
            } else {
                nextLevel = new ArrayList<TreeNode> ();
            }
            
            if(isLeft){
                if(r.left != null)
                    nextLevel.add(r.left);
                if(r.right != null)
                    nextLevel.add(r.right);
            } else {
                if(r.right != null)
                    nextLevel.add(r.right);
                if(r.left != null)
                    nextLevel.add(r.left);
            }
            
            if(nextLevel.size() > 0 && res.size() <= (currLevel+1)) {
                res.add(nextLevel);
            }
            
            if(i == size-1) {
                //shift to next level
                if(currLevel+1 >= res.size()) {
                    //it has been last one, so quit
                    break;
                } else {
                    i = 0;
                    currLevel++;
                    isLeft = (isLeft?false:true);
                    size = nextLevel.size();
                }
            } else {
                i++;
            }
        }
        
       for(ArrayList<TreeNode> r : res) {
           ArrayList<Integer> ir = new ArrayList<Integer> ();
           for(TreeNode t : r) {
               ir.add(t.val);
           }
           result.add(ir);
       }
        
        return result;
    }
}