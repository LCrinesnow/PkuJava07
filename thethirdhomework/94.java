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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rec = new ArrayList<Integer>(); 
        TreeNode p = root;
        if(p == null)
            return rec;
        Stack<TreeNode> s = new Stack<TreeNode>();
        /*s.push(p);
        while(!s.empty() || p!=null ) { //If(!s.empty() || p!=Null ){
           if(p.left!=null){
                s.push(p);
                p = p.left;
           }*如果根节点没有左儿子 则会出错*/
        while(!s.empty() || p!=null ){
            if(p!=null){
                s.push(p);
                p = p.left;
            }
           else{
                TreeNode temp = s.pop(); //rec.add(s.pop());
                rec.add(temp.val);
                p = temp.right; // p = t.right; 此时P为空指针 
           }
        }
        return rec;   
    }
}