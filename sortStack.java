package chapter3;

import java.util.Stack;

/**
 * Created by ning on 12/27/16.
 */
public class sortStack {
    public Stack<Integer> sort(Stack<Integer> stack){
        if(stack==null || stack.isEmpty()){
            return null;
        }
        if(stack.size()==1){
            return stack;
        }
        Stack<Integer> buffer1=new Stack<>();
        Stack<Integer> buffer2=new Stack<>();

        while(!stack.isEmpty()){
            int x=stack.pop();
            if(buffer1.isEmpty()){
                buffer1.push(x);
            }
            else{
                while (buffer1.peek()>x&& !buffer1.isEmpty()){
                    buffer2.push(buffer1.pop());
                }
                buffer1.push(x);
                while (!buffer2.isEmpty()){
                    buffer1.push(buffer2.pop());
                }
            }

        }
        return buffer1;
    }

    public static void main (String args[]){
        sortStack ss=new sortStack();
        Stack<Integer> stack=new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(6);
        stack.push(1);

        Stack<Integer> sortedStack=ss.sort(stack);
    }
}
