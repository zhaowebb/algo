public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(cur1 != null || cur2 != null){
            int int1 = 0;
            int int2 = 0;
            if(cur1 != null){
                int1 = cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                int2 = cur2.val;
                cur2 = cur2.next;
            }
            int sum = carry + int1 +int2;
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }
            else{
                carry = 0;
            }
            
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode l){
        if(l == null) return null;
        ListNode cur = l;
        ListNode prev = null;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }
}