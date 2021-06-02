package AlgoExc03;

public class Stack<T> implements Stackable<T>{

    private Node head = null;


    private class Node {
        T data = null;
        Node next = null;
    }

    @Override
    public void push(T data) {
        Node memorized = head;
        head = new Node();
        head.data = data;
        head.next = memorized;
    }

    @Override
    public T pop() {
        T retObj = head.data;
        head = head.next;
        return retObj;
    }

    @Override
    public T peek() {
        return (head == null) ? null : head.data;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);

    }

    @Override
    public int size() {
        Node temp = head;
        int counter = 0;
        while(temp != null){
            counter ++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public void clear() {
        head = null;

    }

    @Override
    public void print() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
