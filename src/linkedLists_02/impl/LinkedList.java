package linkedLists_02.impl;

import linkedLists_02.Node;
import linkedLists_02.inf.List;

public class LinkedList<T extends Comparable<T>> implements List<T> {

// this is the head node or the root node
    private Node<T> root;
    private int numOfItems;

    public LinkedList() {

    }

    @Override
    public void insert(T data) {

        if (root == null){
            root = new Node<>(data);
        }else{
//            insertBeginning(data);
            insertEnd(data, root);
        }
        numOfItems++;
    }

    @Override
    public void insertMiddle(int index ,T data) {
        Node<T> currNode = root;
        int i = 0;
        while(i < index){
            currNode = currNode.getNextNode();
            i++;
            if (index - i == 1){
                Node<T> newNode = new Node<>(data);
                Node<T> tempNode = currNode.getNextNode();
                currNode.setNextNode(newNode);
                newNode.setNextNode(tempNode);
            }
        }
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    public Node getMiddleNode(){
        int idx = 0;
        Node<T> nodeweNeed = root;
        while(idx < numOfItems / 2){
            idx++;
            nodeweNeed = nodeweNeed.getNextNode();
        }
        return nodeweNeed;
    }

    public Node getMiddleNodeUsingPointers(){
        Node<T> slow = this.root;
        Node<T> fast = this.root;

        while(fast.getNextNode() != null && fast.getNextNode().getNextNode() != null){
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }
        return slow;
    }

    public void traverseReversely(){

        Node<T> currentNode = this.root;
        Node<T> prevNode = null;
        Node<T> nextNode = null;

        while(currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        this.root = prevNode;

    }



    private void insertEnd(T data, Node<T> node) {

        if(node.getNextNode() != null){
            insertEnd(data, node.getNextNode());
        }else{
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }


    @Override
    public void remove(T data) {

//        removing the root node
        if(root == null) return;

//         we want to remove the first node (root)
        if(root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        }else{
            remove(data, root, root.getNextNode());
        }
        numOfItems--;
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode){
//         we have to find the node we want to remove
        while(actualNode != null){
//             this is the node we want to remove
            if(actualNode.getData().compareTo(data) == 0){
//                update the references
                numOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverse() {

        if(root == null) return;

        Node<T> actualNode = root;

        while(actualNode != null){
            System.out.print(actualNode);
            actualNode = actualNode.getNextNode();
        }

    }

    @Override
    public int size() {
        return numOfItems;
    }
}
