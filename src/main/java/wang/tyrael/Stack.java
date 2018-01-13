package wang.tyrael;

import java.util.LinkedList;

public class Stack<E> {
    private LinkedList<E> list= new LinkedList<E>();

    public void push(E e) {
        list.push(e);
    }

    public E pop() {
        return list.pop();
    }

    public E peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
