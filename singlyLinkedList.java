package chapter2;

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
}
