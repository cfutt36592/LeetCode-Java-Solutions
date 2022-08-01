/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> ioMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++)
            ioMap.put(inorder[i], i);//{inorder val : index} 
        
        return builder(0, 0, inorder.length-1, preorder, inorder, ioMap);
    }
    
    public TreeNode builder(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, 
                            Map<Integer, Integer> ioMap){
        if(preStart > preorder.length-1 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = ioMap.get(root.val);

        root.left = builder(preStart+1, inStart, inIndex-1, preorder, inorder, ioMap);
        root.right = builder(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder, inorder, ioMap);
        
        return root;
    }
}
