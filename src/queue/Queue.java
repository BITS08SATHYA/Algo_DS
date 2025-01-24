package queue;

public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public void enqueue(T value){
        this.count++;
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(value);

        if(isEmpty()){
            this.firstNode = this.lastNode;
        }else{
            oldLastNode.setNextNode(this.lastNode);
        }
    }

    public T dequeue(){

        if (isEmpty()) return null;

        this.count--;

        T dataTiDeque = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if(isEmpty()){
            this.lastNode = null;
        }

        return dataTiDeque;

    }

    public boolean isEmpty(){
        return this.firstNode == null;
    }

    public int size(){
        return this.count;
    }


}
