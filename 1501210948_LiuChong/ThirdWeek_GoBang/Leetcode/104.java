package Maximum_Depth_of_Binary_Tree;

import java.util.*;

public class Maximum_Depth_of_Binary_Tree {

	/**
	 * Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 */
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
//DFS   recursion
//    public static int maxDepth(TreeNode root) {
//    	 //每次递归返回左右子树中层数最多的层数，并每次递归都计数＋1
//    	 if(root!=null){
//    	     return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//    	 }
//		 else return 0;
//    }
//DFS
	
//BFS  Queue
	public static int maxDepth(TreeNode root) {
        if(root == null) return 0;  
		Queue<TreeNode> temp=new LinkedList<TreeNode>();
		//		List<Integer>count=new ArrayList<Integer>();
		//队列左和右进队下层子数＋＋，下层进队完毕后，队头出队，出队时［当前层的子数］－－，减到0时，深度＋1，当前层的子数＝下层的子数，队空停止
		int depth=0;
		temp.offer(root);
		int cur_level_num=1;
		int next_level_num=0;
//		count.add(1);
		while(!temp.isEmpty()){
			TreeNode cur=temp.poll();
			cur_level_num--;
			if(cur.left != null){
				temp.offer(cur.left);
				next_level_num++;
			}
			if(cur.right!=null){
				temp.offer(cur.right);
				next_level_num++;

			}
//			count.add(cnt);

			if(cur_level_num==0){
				depth++;
				cur_level_num=next_level_num;
				next_level_num=0;
			}
		}
//		for(int i=0;i<count.size();i++){
//			System.out.print(count.get(i));
//		}
		return depth;
	}
//BFS
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
		
		System.out.println(maxDepth(n1));
	}

}
