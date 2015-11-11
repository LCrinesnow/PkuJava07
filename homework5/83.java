/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       
       //循环判断，如果相同就修改next指针指向，如果不同则跳到下一个
       if(head == null)
       {
           return head;
       }
       
       ListNode p = head;//一个从头结点开始的指针
       while(p.next != null)
       {
           if(p.val == p.next.val)
           {
               p.next = p.next.next;
           }
           else
           {
               p = p.next;
           }
       }
       
        return head;
    }
}