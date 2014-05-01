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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length-1];
        int rootPos = -1;
        int[] inorderLeft = null;
        int[] postorderLeft = null;
        int[] inorderRight = null;
        int[] postorderRight = null;
        //Find root in inorder so that we can find leftEndPos which should just before the root
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }
        
        if(rootPos > 0) {
            //There is a left child tree here
            inorderLeft = Arrays.copyOfRange(inorder, 0, rootPos);
            postorderLeft = Arrays.copyOfRange(postorder, 0, rootPos);
        }
        
        if(rootPos < (inorder.length - 1)) {
            //There is a right child tree here
            inorderRight = Arrays.copyOfRange(inorder, rootPos+1, inorder.length);
            postorderRight = Arrays.copyOfRange(postorder, rootPos, postorder.length-1);
        }
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }
}