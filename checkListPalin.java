package chapter2;

/**
 * Created by ning on 12/10/16.
 */
public class checkListPalin {
    public int getListLength(ListNode head){
        int count=0;
        if(head==null){
            return count;
        }
        if(head.next==null){
            return ++count;
        }
        ListNode runner=head;
        while(runner!=null){
            runner=runner.next;
            count++;
        }
        return count;
    }

    public ListNode addingDummyMidNode(ListNode head, int count){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode tempRunner=head;
        while(count!=1){
            tempRunner=tempRunner.next;
            count--;
        }
        ListNode newDummy=new ListNode(0);
        newDummy.next=tempRunner.next;
        tempRunner.next=newDummy;
        return head;
    }

    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode runner=head;
        ListNode newHead=null;
        while(runner!=null){
            ListNode newTemp=new ListNode(runner.val);
            newTemp.next=newHead;
            newHead=newTemp;
            runner=runner.next;
        }
        return newHead;
    }

    public Boolean checkPalin(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        int length=getListLength(head);
        if(length%2==0){
            head=addingDummyMidNode(head, length/2);
        }
        int sep=length/2;
        ListNode runner=head;
        while(sep!=0 && runner!=null){
            runner=runner.next;
            sep--;
        }
        ListNode sndHalf=reverseList(runner.next);

        while(head!=null && sndHalf!=null){
            if(head.val==sndHalf.val){
                head=head.next;
                sndHalf=sndHalf.next;
            }
            else{
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        checkListPalin cp=new checkListPalin();
        singlyLinkedList sl=new singlyLinkedList();
        int arr[]={3,2,1,2,3};
        int arr2[]={3,2,2,3};
        int arr3[]={3,1,2,3};
        ListNode head=sl.generateList(arr);
        ListNode head2=sl.generateList(arr2);
        ListNode head3=sl.generateList(arr3);

        cp.checkPalin(head);
        cp.checkPalin(head2);
        cp.checkPalin(head3);
    }

}
