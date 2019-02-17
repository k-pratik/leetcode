public class AddTwoNumber {

    public static void main(String[] args) {


        AddTwoNumber addTwoNumber = new AddTwoNumber();

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next =  new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next =  new ListNode(7);


        ListNode r = addTwoNumber.addTwoNumbers(head1, head2);
        while (r!=null){
            System.out.println(r.val);
            r=r.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int carry = 0;
            ListNode result = null;
            ListNode tmpNode = result;
            while (l1 !=null || l2 != null){

                int tmp;
                if(l1==null){
                    tmp = l2.val + carry;
                }
                else if(l2==null){
                    tmp = l1.val + carry;
                } else {
                    tmp = l1.val + l2.val + carry;
                }
                carry = tmp/10;
                int res = tmp%10;
                ListNode l = new ListNode(res);
                if(result == null) {
                    result = l;
                    tmpNode = result;
                } else{
                    tmpNode.next = l;
                    tmpNode = tmpNode.next;
                }

                if(l1!=null){
                    l1=l1.next;
                }
                if(l2!=null){
                    l2=l2.next;
                }



            }
            if(carry>0){
                tmpNode.next=new ListNode(carry);
            }

            return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
