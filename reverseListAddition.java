package chapter2;

/**
 * Created by ning on 12/9/16.
 */
public class reverseListAddition {
    public ListNode addition(ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int inc=0;
        ListNode addDummy=new ListNode(0);
        ListNode addRunner=addDummy;
        while(l1!=null || l2!=null ||inc!=0){
            int val1= l1==null? 0: l1.val;
            int val2= l2==null? 0: l2.val;

            int tempAdd=val1+val2+inc;
            inc=tempAdd/10;

            ListNode newNode=new ListNode(tempAdd%10);
            addRunner.next=newNode;
            addRunner=addRunner.next;
            l1 = l1 ==null? l1: l1.next;
            l2 = l2 ==null? l2: l2.next;
        }

        return addDummy.next;
    }

    public static void main(String args[]){
        reverseListAddition rla=new reverseListAddition();
        singlyLinkedList sl=new singlyLinkedList();
        int arr[]={7,1,6};
        int arr2[]={5,9,2};
        ListNode head=sl.generateList(arr);
        ListNode head2=sl.generateList(arr2);

        rla.addition(head,head2);
    }

}
