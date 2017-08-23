/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(cur1 != null || cur2 != null){
            if(cur1 != null){
                stk1.push(cur1.val);
                cur1 = cur1.next;
            }
            if(cur2 != null){
                stk2.push(cur2.val);
                cur2 = cur2.next;
            }
        }
        
        int sum = 0;
        ListNode node = new ListNode(0);
        
        while(!stk1.isEmpty() || ! stk2.isEmpty()){
            if(!stk1.isEmpty()){
                sum += stk1.pop();
            }
            if(!stk2.isEmpty()){
                sum += stk2.pop();
            }
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = node;
            node = head;
            sum /= 10;
        }
        
        return node.val == 0 ? node.next : node;
    }
}