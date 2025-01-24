package linkedLists_02.double_LL;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T data){

        Node<T> newNode = new Node<>(data);

        if(tail == null){
            head = tail = newNode;
        }else{
//            we have to insert the new item to the end of the list
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }

    }
//    forward traverse
    public void traverseForward(){

        Node<T> actualNode = head;

        while(actualNode != null){
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }

    }

//    backward traverse
    public void traverseBackward(){

        Node<T> actualNode = tail;
        while(actualNode != null){
            System.out.println(actualNode);
            actualNode = actualNode.getPreviousNode();
        }

    }

}
