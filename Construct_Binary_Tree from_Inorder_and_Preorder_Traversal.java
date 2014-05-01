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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        
        int rootVal = preorder[0];
        int rootPos = -1;
        int[] preorderLeft = null;
        int[] inorderLeft = null;
        int[] preorderRight = null;
        int[] inorderRight = null;
        
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }
        
        if(rootPos > 0) {
            preorderLeft = Arrays.copyOfRange(preorder, 1, rootPos+1);
            inorderLeft = Arrays.copyOfRange(inorder, 0, rootPos);
        }
        
        if(rootPos < (inorder.length-1)) {
            preorderRight = Arrays.copyOfRange(preorder, rootPos+1, preorder.length);
            inorderRight = Arrays.copyOfRange(inorder, rootPos+1, inorder.length);
        }
        
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}