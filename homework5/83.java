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
       
       //ѭ���жϣ������ͬ���޸�nextָ��ָ�������ͬ��������һ��
       if(head == null)
       {
           return head;
       }
       
       ListNode p = head;//һ����ͷ��㿪ʼ��ָ��
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