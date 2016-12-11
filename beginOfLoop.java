package chapter2;

import java.util.HashMap;

/**
 * Created by ning on 12/10/16.
 */
public class beginOfLoop {
    public ListNode findLoopBegin1(ListNode head){
        HashMap<ListNode,Integer> nodeRegister=new HashMap<>();
        ListNode runner=head;
        while(runner!=null){
            if(!nodeRegister.containsKey(runner)){
                nodeRegister.put(runner,1);
                runner=runner.next;
            }
            else{
                break;
            }
        }
        runner.next=null;
        return runner;
    }

    public ListNode findLoopBegin2(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast.next==null){
            return null;
        }
        slow=head;
        while (fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        return fast;
    }

    public static void main(String args[]){
        beginOfLoop bl=new beginOfLoop();
        singlyLinkedList sl=new singlyLinkedList();
        int arr[]={1,2,3,4,5,6,7,4};
        ListNode head=sl.generateListOneLoop(arr);

        //bl.findLoopBegin1(head);
        bl.findLoopBegin2(head);
    }
}
