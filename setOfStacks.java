package chapter3;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ning on 12/12/16.
 */
public class setOfStacks {
    int capacity;
    int stackCount;
    HashMap<Integer,Stack> stackSet=new HashMap<>();

    public setOfStacks(){
        this.capacity=10;
        this.stackCount=0;
    }

    public setOfStacks(int c){
        this.capacity=c;
        this.stackCount=0;
    }

    private void newStack(Object item){
        stackCount++;
        Stack newStack=new Stack();
        newStack.push(item);
        stackSet.put(stackCount,newStack);
    }

    public void push(Object item){
        if(stackSet.size()<1){
            newStack(item);
        }
        else{
            Stack tempStack=stackSet.get(stackCount);
            if(tempStack.size()==capacity){
                newStack(item);
            }
            else{
                tempStack.push(item);
                stackSet.put(stackCount,tempStack);
            }
        }
    }

    public void pop(){
        if(stackSet.size()<1){
           return;
        }
        Stack tempStack=stackSet.get(stackCount);
        if(tempStack.size()==0){
            stackSet.remove(stackCount);
            stackCount--;
            pop();
        }
        else{
            tempStack.pop();
            stackSet.put(stackCount,tempStack);
        }

    }

    public void pop(int n){
        if(stackSet.size()<1){
            return;
        }
        if(n==0 || n>stackCount){
            return;
        }
        else{
            Stack tempStack=stackSet.get(n);
            if(tempStack.size()==0){
                return;
            }
            tempStack.pop();
            stackSet.put(n,tempStack);
        }
    }

    public void peek(){
        if(stackSet.size()<1){
            return;
        }
        Stack tempStack=stackSet.get(stackCount);
        if(tempStack.size()==0){
            return;
        }
        tempStack.peek();
    }

    public static void main(String args[]){
        setOfStacks ss=new setOfStacks(5);

        for(int i=0;i<=15;i++){
            ss.push(i);
        }

        ss.pop();
        ss.pop();
        ss.pop(4);
        ss.pop(2);
        ss.push(16);
    }
}
