public class SortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = sortList(head);

        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }


    public static ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        //Applying merge sort algorithm
        //Split list into two halves
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode endOfFirst = head;
        while (p2!=null && p2.next!=null){
            endOfFirst = p1;
            p1=p1.next;
            p2=p2.next.next;
        }

        //List is split into two halves , head to endOfFirst and p1 to end
        endOfFirst.next = null;
        //Recusrively split both the list
        ListNode l = sortList(head);
        ListNode r = sortList(p1);

        //Merge two list
        ListNode res = merge(l,r);

       return res;

    }

    public static ListNode merge(ListNode l, ListNode r){
        if(l==null){
            return r;
        }
        if(r==null){
            return l;
        }

        if(l.val < r.val){
            l.next = merge(l.next,r);
            return l;
        } else{
            r.next = merge(l,r.next);
            return r;
        }


    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
