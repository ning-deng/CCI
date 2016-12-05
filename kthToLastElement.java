package chapter2;

/**
 * Created by ning on 12/4/16.
 */
public class kthToLastElement {
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

    public llNode findKthToLast(llNode head, int k){
        llNode runner=head;
        llNode pointer=head;

        int count=0;
        while(count<k && runner!=null){
            runner=runner.next;
            count++;
        }

        while(runner!=null){
            runner=runner.next;
            pointer=pointer.next;
        }

        return pointer;
    }

    public static void main(String args[]){
        kthToLastElement kle=new kthToLastElement();

        llNode head=new kthToLastElement().new llNode(1);
        kle.appendTailNode(head,2);
        kle.appendTailNode(head,3);
        kle.appendTailNode(head,4);
        kle.appendTailNode(head,5);
        kle.appendTailNode(head,6);
        llNode tempHead=kle.findKthToLast(head,4);

        System.out.print(tempHead.data);
    }

}
