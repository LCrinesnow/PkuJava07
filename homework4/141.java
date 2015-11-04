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
        
        //x为快指针，y为慢指针
        ListNode x = head;
        ListNode y = head;
        
        if (head == null)
         return false;
        
        while (x != null && x.next != null )
        {
            x = x.next.next; //x一次走两个
            y = y.next;     //y一次走一个
            
            if (x == y)
             return true;
        }
        return false;
    }
}