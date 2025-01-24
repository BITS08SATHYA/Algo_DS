package stack;

public class Stack<T extends Comparable<T>>{

    private Node<T> head;
    private int count;

//    push method
    public void push(T data){
        count++;

        if(head == null){
            head = new Node<>(data);
        }else{
            Node<T>  newNode = new Node<>(data);
            newNode.setNextNode(head);
            head = newNode;
        }

    }

//    remove the last item we have inserted
    public T pop(){
        T item = head.getData();
        head = head.getNextNode();
        count--;
        return item;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }




}
