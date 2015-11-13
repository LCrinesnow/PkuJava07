package Binary_Tree_Postorder_Traversal;

import java.util.*;

import Binary_Tree_Preorder_Traversal.Binary_Tree_Preorder_Traversal.TreeNode;

public class Binary_Tree_Postorder_Traversal {
	public static class TreeNode {
	     int val;
         TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	//代码分两部分1入栈阶段2.出栈阶段2.1情况1:子全出，此时根应出2.子根无子，出
	public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> postorder=new ArrayList<Integer>();
    	if(root==null)return postorder;
    	Stack<TreeNode> temp=new Stack<TreeNode>();
    	temp.push(root);
//		System.out.println(temp.peek().val);
//    	int i=0;
		TreeNode cur=root,prev=null;
    	while(!temp.isEmpty()){
//			System.out.println(temp.peek().val);
			cur=temp.peek();
//根节点的左右已出栈，pop(根)?????why不行
//    		if(temp.contains(cur.right)==false&&temp.contains(cur.left)==false){
//    			postorder.add(temp.peek().val);
//    			temp.pop();
//    		}
//当前节点的左或右等于先前出栈节点。则证明现在已经到了根节点出栈的时候了
    		if(prev!=null&&(cur.left==prev||cur.right==prev)){
    			postorder.add(temp.peek().val);
    			prev=temp.pop();
//    			System.out.println("prev:"+prev.val);

    		}else{
    			//否则的话还处于一开始入栈阶段
    			if(cur.right!=null){
        			temp.push(cur.right);
        		}
//    			System.out.println(temp.peek().val);

        		if(cur.left!=null){
        			temp.push(cur.left);
        		}
    		}
    		//节点无子
    		if(cur.right==null&&cur.left==null){
    			postorder.add(temp.peek().val);
    			prev=temp.pop();
//    			System.out.println("prev:"+prev.val);

    		}
//			System.out.println(temp.peek().val);
		
    	}
        return postorder;
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
//		n1.right=n3;
//		
////		n2.left=null;
////		n2.right=null;
////		
//		n3.left=n4;
//		n3.right=null;
//		
//		n4.right=n5;
//		n4.left=n6;
//		
////		n5.left=null;
////		n5.right=null;
////		
////		n6.left=null;
////		n6.right=null;
		List<Integer> postorderoutput=new ArrayList<Integer>();
		postorderoutput=postorderTraversal(n1);
//		System.out.println("hhhhh");

		for(int i=0;i<postorderoutput.size();i++){
			System.out.println(postorderoutput.get(i));
		}
	}

}
