package chapter3;

/**
 * Created by ning on 12/11/16.
 */
public class Queue {
    Node first, last;

    public void enqueue(Object item){
        if(first==null){
            last=new Node(item);
            first=last;
        }
        else{
            Node tempNewNode=new Node(item);
            last.next=tempNewNode;
            last=last.next;
        }
    }

    public Object dequeue(){
        if(first==null){
            return null;
        }
        Object item=first.val;
        first=first.next;
        return item;
    }
}
