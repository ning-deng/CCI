package chapter3;

/**
 * Created by ning on 12/11/16.
 */
public class minStack {
    intNode top;
    intNode min;

    public minStack(){
        this.top=null;
        this.min=null;
    }

    public void push(int value){
        intNode newTop=new intNode(value);
        if(top==null){
            top=newTop;
        }
        else {
            newTop.next=top;
            top=newTop;
        }
        if(min==null){
            min=newTop;
        }
        else if(min.val>value){
            min=newTop;
        }
    }

    public Object pop(){
        if(top!=null){
            int item= top.val;
            //top=top.next;

            if(min==top){
                intNode runner=min;
                int newMin=0;
                if(runner.next!=null){
                    newMin=runner.next.val;
                    runner=runner.next;
                    min=runner;
                }
                else{
                    min=null;
                }
                while(runner!=null){
                    if(runner.val<newMin){
                        min=runner;
                        newMin=runner.val;

                    }
                    runner=runner.next;
                }
            }
            top=top.next;
            return item;
        }
        else{
            return null;
        }

    }

    public Object peek(){
        if(top!=null){
            return top.val;
        }
        else{
            return null;
        }
    }

    public Object min(){
        if(min!=null){
            return min.val;
        }
        else return null;
    }

    public static void main(String args[]){
        minStack ms=new minStack();
        ms.push(4);
        ms.push(2);
        ms.push(0);

        ms.pop();
        ms.peek();
        ms.min();
    }
}
