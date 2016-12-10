package chapter2;

/**
 * Created by ning on 12/8/16.
 */
public class partitionLinkedList {

    public void  delNode(ListNode head, ListNode delNode){
        while(head.next!=delNode){
            head=head.next;
        }
        head.next=head.next.next;
    }

    public ListNode partition(ListNode head, int x){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode sDummy=new ListNode(0);
        ListNode bDummy=new ListNode(0);

        ListNode sRunner=sDummy;
        ListNode bRunner=bDummy;

        ListNode tempHead=head;

        while(tempHead!=null){
            if(tempHead.val>=x){
                bRunner.next=tempHead;
                bRunner=bRunner.next;
            }
            else{
                sRunner.next=tempHead;
                sRunner=sRunner.next;
            }
            tempHead=tempHead.next;
        }
        bRunner.next=null;
        sRunner.next=bDummy.next;
        return sDummy.next;
    }

    public static void main(String args[]){
        partitionLinkedList pll=new partitionLinkedList();
        singlyLinkedList sl=new singlyLinkedList();
        int arr[]={2,1};
        ListNode head=sl.generateList(arr);

        pll.partition(head,2);
    }
}
