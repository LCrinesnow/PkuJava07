/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if ( root == null /*|| root.left == null || root.right == null*/)
          return true;
        //boolean l = isSymmetric(root.left);
        //boolean r = isSymmetric(root.right);
        //boolean flag = 
        return Symmetric(root.left,root.right);
        //if ( isSymmetric(root.left) && isSymmetric(root.right))
          //return true;
        //else
          //return false;
    }
    public boolean Symmetric(TreeNode root1,TreeNode root2)
    {
            /*if (root1.val == root2.val)
            
              return true;
            else
              return false;*/
             if (root1 == null && root2 == null)
                return true;
             else if ( root1 == null && root2 != null || root1 != null && root2 == null || root1.val != root2.val || !Symmetric( root1.left, root2.right) || !Symmetric( root1.right, root2.left))
                return false;
             else
                return true;
    }
}