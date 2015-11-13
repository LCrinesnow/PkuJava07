package Binary_Tree_Preorder_Traversal;

import java.util.*;


public class Binary_Tree_Preorder_Traversal {

	public static class TreeNode {
	     int val;
         TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
    public static List<Integer> preorderTraversal(TreeNode root) {
	    //入栈，访问（输出），pop，压右压左。
    	List<Integer> preorder=new ArrayList<Integer>();
	    if(root!=null) return preorder;
    	Stack<TreeNode> temp=new Stack<TreeNode>();
	     temp.push(root);
	     
	     while(!temp.isEmpty()){
	    	 preorder.add(temp.peek().val);
	    	 TreeNode cur=temp.pop();
	    	 if(cur.right!=null){
	    		 temp.push(cur.right);
	    	 }
	    	 if(cur.left!=null){
	    		 temp.push(cur.left);
	    	 }
	     }
	     return preorder;
	     
    }
	public static void main(String[] args) {
		//		1
		//	 2	   3
		//		 4   
		//	   6   5	
		// TODO Auto-generated method stub
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		
		
		n1.left=n2;
		n1.right=n3;
		
//		n2.left=null;
//		n2.right=null;
//		
		n3.left=n4;
		n3.right=null;
		
		n4.right=n5;
		n4.left=n6;
		
//		n5.left=null;
//		n5.right=null;
//		
//		n6.left=null;
//		n6.right=null;
		List<Integer> preorderoutput=new ArrayList<Integer>();
		preorderoutput=preorderTraversal(n1);
		for(int i=0;i<preorderoutput.size();i++){
			System.out.println(preorderoutput.get(i));
		}
	}

}
