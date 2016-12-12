package chapter3;

/**
 * Created by ning on 12/11/16.
 */
public class minStackConstant {
    intNode top;
    int min;

    public minStackConstant(){
        this.top=null;
        this.min=Integer.MAX_VALUE;
    }

    public void push(int value){
        intNode newTop=new intNode(value);

        if(top==null){
            min=value;
        }

        if(value<=min){
            intNode newMinNode=new intNode(min);
            newMinNode.next=top;
            top=newMinNode;
            min=value;
        }

        newTop.next=top;
        top=newTop;
    }

    public Object pop(){
        if(top!=null){
            int item= top.val;
            top=top.next;

            if(item==min){
                min=top.val;
                top=top.next;
            }
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
        if(top==null){
            return null;
        }
        return min;
    }

    public static void main(String args[]){
        minStackConstant msc=new minStackConstant();
        msc.push(0);
        msc.push(1);
        msc.push(0);

        msc.min();
        msc.pop();
        msc.min();
    }
}
