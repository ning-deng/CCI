package chapter3;

/**
 * Created by ning on 12/11/16.
 */
public class Stack {
    Node top;

    public Object pop(){
        if(top!=null){
            Object item=top.val;
            top=top.next;
            return item;
        }

        return null;
    }

    public void push(Object item){
        Node newTop=new Node(item);
        newTop.next=top;
        top=newTop;
    }

    public Object peek(){
        if(top!=null){
            return top.val;
        }
        return null;
    }
}
