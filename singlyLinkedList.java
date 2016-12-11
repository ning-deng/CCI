package chapter2;

import java.util.HashMap;

/**
 * Created by ning on 12/9/16.
 */
public class singlyLinkedList {
    public ListNode generateList(int arr []){
        if(arr==null|| arr.length==0){
            return null;
        }
        if(arr.length==1){
            ListNode head=new ListNode(arr[0]);
            return head;
        }
        ListNode head=new ListNode(arr[0]);
        ListNode runner=head;
        for(int i=1;i<arr.length;i++){
            ListNode tempNewNode=new ListNode(arr[i]);
            runner.next=tempNewNode;
            runner=runner.next;
        }
        return head;
    }

    public ListNode generateListOneLoop(int arr[]){
        if(arr==null|| arr.length==0){
            return null;
        }
        if(arr.length==1){
            ListNode head=new ListNode(arr[0]);
            return head;
        }
        HashMap<Integer,ListNode> noDupReg=new HashMap<>();
        ListNode head=new ListNode(arr[0]);
        ListNode runner=head;
        noDupReg.put(arr[0],head);

        for(int i=1;i<arr.length;i++){
            if(!noDupReg.containsKey(arr[i])){
                ListNode tempNewNode=new ListNode(arr[i]);
                noDupReg.put(arr[i],tempNewNode);
                runner.next=tempNewNode;
                runner=runner.next;
            }
            else{
                runner.next=noDupReg.get(arr[i]);
                break;
            }
        }
        return head;
    }
}
