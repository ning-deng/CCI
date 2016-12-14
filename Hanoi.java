package chapter3;

import java.util.*;
import java.util.Stack;

/**
 * Created by ning on 12/13/16.
 */
public class Hanoi {
    int N;
    Stack src=new Stack();
    Stack bridge=new Stack();
    Stack dest=new Stack();

    public Hanoi(int x){
        this.N=x;
        for(int i=N;i>0;i--){
            src.push(i);
        }
    }
    public Hanoi(){
        this.N=10;
        for(int i=N;i>0;i--){
            src.push(i);
        }
    }

    public void hanoiMove(Stack from, Stack buf, Stack to, int num){
        if(num==0){
            return;
        }
        if(num==1){
            Object item=from.pop();
            to.push(item);
            return;
        }
        if(num==2){
            Object item=from.pop();
            buf.push(item);

            Object bottom=from.pop();
            to.push(bottom);

            Object top=buf.pop();
            to.push(top);
            return;
        }

        hanoiMove(from, to, buf, num-1);
        hanoiMove(from, buf, to, 1);
        hanoiMove(buf, from, to, num-1);
    }

    public static void main(String args[]){
        Hanoi hanoi=new Hanoi(5);
        hanoi.hanoiMove(hanoi.src,hanoi.bridge,hanoi.dest,hanoi.N);
    }


}
