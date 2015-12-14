package lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//    TreeNode ancestor=new TreeNode();
		//	System.out.println(root.val);
		//	System.out.println(p.val);
		//	System.out.println(q.val);
		
			if(root.val>p.val&&root.val>q.val){ //=不用考虑因为是BST
				System.out.println(root.val);
		
				root=root.left;
		
				return lowestCommonAncestor(root,p,q);
			}
			else if(root.val<p.val&&root.val<q.val){
				System.out.println(root.val);
		
				root=root.right;
		
				return lowestCommonAncestor(root,p,q);
			}
			else {    //root.val>p.val&&root.val<q.val
				TreeNode ancestor=root;
				System.out.println(root.val);
				return ancestor;
			}
	}
}


