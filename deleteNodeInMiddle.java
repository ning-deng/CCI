package chapter2;

/**
 * Created by ning on 12/4/16.
 */
public class deleteNodeInMiddle {
    public class llNode{
        int data;
        llNode next;

        public llNode(int d){
            this.data=d;
            this.next=null;
        }
    }
    //this function should be in a linked list class
    public void appendTailNode(llNode head, int d){
        llNode tailNode=new llNode(d);
        while(head.next!=null){
            head=head.next;
        }
        head.next=tailNode;
    }

    public void deleteNodeByIndex(llNode node){
        int data=node.next.data;
        node.data=data;
        node.next=node.next.next;
    }

    public static void main(String args[]){
        deleteNodeInMiddle dnm=new deleteNodeInMiddle();

        llNode head=new deleteNodeInMiddle().new llNode(1);
        dnm.appendTailNode(head,2);
        dnm.appendTailNode(head,3);
        dnm.appendTailNode(head,4);
        dnm.appendTailNode(head,5);
        dnm.appendTailNode(head,6);

        int count=4;
        llNode tempPointer=head;
        while(count>0){
            tempPointer=tempPointer.next;
            count--;
        }
        dnm.deleteNodeByIndex(tempPointer);
    }
}
