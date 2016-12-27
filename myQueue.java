package chapter3;

import java.util.Stack;

/**
 * Created by ning on 12/27/16.
 */
public class myQueue {

        private Stack<Integer> frontStack=new Stack<>();
        private Stack<Integer> endStack=new Stack<>();

        public void push(int x) {
            frontStack.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            peek();
            endStack.pop();
        }

        // Get the front element.
        public int peek() {
            if(endStack.isEmpty()){
                while(!frontStack.isEmpty()){
                    endStack.push(frontStack.pop());
                }
            }
            return endStack.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return frontStack.isEmpty() && endStack.isEmpty();
        }

}
