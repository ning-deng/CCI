package chapter3;

import java.util.HashMap;

/**
 * Created by ning on 12/11/16.
 */
public class stacksInAnArray {
    int k;//k stacks
    Node stackArr[];
    HashMap<Integer,Node> topPointerMap=new HashMap<>();

    public stacksInAnArray(int numStacks, int arrLength){
        this.k=numStacks;
        this.stackArr=new Node[arrLength];
        //this.topPointerMap=null;
    }

    public void push(int n, Object value){
        if(n>this.k-1||n<0){
            System.out.println("Invalid stack number");
            return;
        }

        Node newNode=new Node(value);
        newNode.next=null;

        Boolean space=false;
        for(int i=0;i<stackArr.length;i++){
            if(stackArr[i]==null){
                stackArr[i]=newNode;
                space=true;
                break;
            }
        }
        if(space==true){
            if(topPointerMap!=null && topPointerMap.containsKey(n)){
                Node oldTop=topPointerMap.get(n);
                newNode.next=oldTop;
            }
            topPointerMap.put(n,newNode);
        }
        else{
            System.out.println("No enough space for the data");
        }
    }

    public Object pop(int n){
        if(n>this.k-1||n<0){
            System.out.println("Invalid stack number");
            return null;
        }
        if(!topPointerMap.containsKey(n)){
            return null;
        }

        Node topn=topPointerMap.get(n);
        Object item=null;
        if(topn!=null){
            item=topn.val;
            topn=topn.next;
        }
        topPointerMap.put(n,topn);
        return item;
    }

    public Object peek(int n){
        if(n>this.k-1||n<0){
            System.out.println("Invalid stack number");
            return null;
        }
        if(!topPointerMap.containsKey(n)){
            return null;
        }
        if(topPointerMap.get(n)!=null){
            return topPointerMap.get(n).val;
        }
        return null;

    }

    public static void main(String args[]){
        stacksInAnArray sa=new stacksInAnArray(3,10);

        sa.push(0, "A");
        sa.push(1,"B");
        sa.push(2,"C");
        sa.push(0,"D");

        sa.pop(0);
        sa.pop(1);
        sa.pop(1);

        sa.peek(0);

    }
}
