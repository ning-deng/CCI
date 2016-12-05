package chapter2;

import java.util.HashMap;

/**
 * Created by ning on 12/3/16.
 */
public class deleteDupLinkedList {

    public class llNode{
        int data;
        llNode next;

        public llNode(int d){
            this.data=d;
            this.next=null;
        }
    }
    //this function should be in a linked list class.
    public void appendTailNode(llNode head, int d){
        llNode tailNode=new llNode(d);
        while(head.next!=null){
            head=head.next;
        }
        head.next=tailNode;
    }

    //method 1: with a buffer, which is modeled by a hashmap, the time complexity is O(n), the space complexity is O(n)
    public void deleteDup(llNode head){
        HashMap<Integer,llNode> bufferMap=new HashMap<>();

        bufferMap.put(head.data,head);
        llNode tempPointer=head;
        llNode runner=tempPointer.next;

        //head=head.next;

        while(runner!=null){
            if(!bufferMap.containsKey(runner.data)){
                bufferMap.put(runner.data,runner);
                tempPointer=tempPointer.next;
                runner=runner.next;
            }
            else{
                tempPointer.next=runner.next;
                runner=runner.next;
            }

        }
    }

    //method 2: without a buffer, we can only use two pointers, and the time complexity is O(n^2)
    public void deleteDupNoBuffer(llNode head){
        llNode tempHead=head;
        llNode runner=tempHead.next;
        llNode pointer=tempHead;

        while(tempHead!=null){
            while(runner!=null){
                if(runner.data==tempHead.data){
                    pointer.next=runner.next;
                    runner=runner.next;
                }
                else{
                    pointer=pointer.next;
                    runner=runner.next;
                }
            }
            tempHead=tempHead.next;
            pointer=tempHead;
            if(tempHead!=null){
                runner=tempHead.next;
            }
        }
    }

    public static void main(String args[]){
        deleteDupLinkedList ddll=new deleteDupLinkedList();

        llNode head=new deleteDupLinkedList().new llNode(1);
        ddll.appendTailNode(head,2);
        ddll.appendTailNode(head,3);
        ddll.appendTailNode(head,2);
        ddll.appendTailNode(head,4);
        ddll.appendTailNode(head,3);
        llNode tempHead=head;

        ddll.deleteDup(head);
        llNode tempHead2=head;

        llNode head2=new deleteDupLinkedList().new llNode(3);
        ddll.appendTailNode(head2,2);
        ddll.appendTailNode(head2,5);
        ddll.appendTailNode(head2,7);
        ddll.appendTailNode(head2,2);
        ddll.appendTailNode(head2,3);

        ddll.deleteDupNoBuffer(head2);
        llNode tempHead3=head2;
    }
}
