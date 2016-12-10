package chapter2;


import java.util.ArrayList;

/**
 * Created by ning on 12/10/16.
 */
public class listAddition {
    int inc=0;
    public ListNode newHead=null;
    public ArrayList<ListNode> puffList(ListNode l1, ListNode l2){
        ListNode runner1=l1;
        ListNode runner2=l2;
        ArrayList<ListNode> puffLists=new ArrayList<>();
        while(runner1.next!=null ||runner2.next!=null){
            if(runner1.next==null && runner2.next!=null){
                ListNode tempNew=new ListNode(0);
                tempNew.next=l1;
                l1=tempNew;
                runner2=runner2.next;
            }
            else if(runner2.next==null && runner1.next!=null){
                ListNode tempNew=new ListNode(0);
                tempNew.next=l2;
                l2=tempNew;
                runner1=runner1.next;
            }
            else{
                runner1 =runner1.next;
                runner2=runner2.next;
            }
        }
        puffLists.add(l1);
        puffLists.add(l2);
        return puffLists;
    }

    public ListNode addition(ListNode l1, ListNode l2){
        ArrayList <ListNode> list= puffList(l1,l2);

        ListNode returnHead=additionRecursion(list.get(0),list.get(1));

        if(inc>0){
            ListNode newTemp=new ListNode(inc);
            newTemp.next=returnHead;
            returnHead=newTemp;
        }

        return returnHead;

    }

    public ListNode additionRecursion(ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return null;
        }
        additionRecursion(l1.next,l2.next);

        int tempVal=l1.val+l2.val+inc;
        inc=tempVal/10;
        ListNode newTemp=new ListNode(tempVal%10);
        if(newHead==null){
            newHead=newTemp;
        }
        else {
            newTemp.next = newHead;
            newHead = newTemp;
        }
        return newHead;
    }

    public static void main(String args[]){
        listAddition la=new listAddition();
        singlyLinkedList sl=new singlyLinkedList();
        int arr[]={1,0,0,7};
        int arr2[]={9,3};
        ListNode head1=sl.generateList(arr);
        ListNode head2=sl.generateList(arr2);

        la.addition(head1,head2);
    }


}
