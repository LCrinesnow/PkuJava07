package Palindrome_Linked_list;

import java.util.*;

public class Palindrome_Linked_list {
	/**
	 * Definition for singly-linked list.
	 
	 */
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }//构造函数 输入X
	  }
	    public static boolean isPalindrome(ListNode head) {
	    	if(head==null) return true;
	    	ListNode Mid=partitionList(head);   //1->2->3  ->4->5->6   
//			System.out.println(Mid.val);		//Mid=3
	    	Mid=reverseList(Mid);   		    //1->2->3  ->6->5->4   1->2->3->6->5->4
//	    	System.out.println(Mid.val);		//Mid＝6 返回了6，而不是3.因为中间有个指针
	    	
	    	while(head!=null&&Mid!=null){
	    		if(head.val!=Mid.val) {
//	    			System.out.println(head.val);
//	    			System.out.println("错");
	    			return false;
	    		}
	    		else{
//	    			System.out.println(Mid.val);
//	    			System.out.println("对");

	    		}
	    		head=head.next;
	    		Mid=Mid.next;
	    	}
//print 链表
//			while(Mid.next!=null){
//				System.out.println(Mid.val);
//				Mid=Mid.next; 
//			}
	        return true;
	    }
	    public static ListNode reverseList(ListNode head) {
	        ListNode newHead = null;
	        while(head != null){
	            ListNode next = head.next;
	            head.next = newHead;
	            newHead = head;
	            head = next;
	        }
	        return newHead;
	    }
	    public static ListNode partitionList(ListNode head){
	    	//同一起跑线起跑
	    	ListNode hare=head;
	    	ListNode tort=head;
	    	//必须要先hare.next!=null而不能先hare.next.next!=null，否则会报空指针。&&是有顺序的？？？
	    	while(hare.next!=null&&hare.next.next!=null){  //兔子有路跑的话，龟肯定也有路跑，当兔子到终点了，比赛截至，龟因为速度是兔子的1/2，所以在中点。如果龟速度是1/3，则在1/3点。
	    		hare=hare.next.next;
	    		tort=tort.next;
	    	}
	    	return tort;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(2);
		ListNode n5=new ListNode(1);
//		ListNode n6=new ListNode(1);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
//		n5.next=n6;
		
		boolean IF= isPalindrome(n1);
		
		System.out.println(IF);
		
		
		


	}

}
