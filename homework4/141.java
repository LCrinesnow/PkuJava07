/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        //xΪ��ָ�룬yΪ��ָ��
        ListNode x = head;
        ListNode y = head;
        
        if (head == null)
         return false;
        
        while (x != null && x.next != null )
        {
            x = x.next.next; //xһ��������
            y = y.next;     //yһ����һ��
            
            if (x == y)
             return true;
        }
        return false;
    }
}