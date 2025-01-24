package avl;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {

        if(root == null){
            root = new Node<>(data,null);
        }else{
            insert(data,root);
        }

    }

    private void insert(T data, Node<T> node) {

        if(node.getData().compareTo(data) > 0){
            if(node.getLeftChild() != null){
                insert(data, node.getLeftChild());
            }else{
                node.setLeftChild(new Node<>(data, node));
            }
        }else{
            if(node.getRightChild() != null){
                insert(data, node.getRightChild());
            }else{
                node.setRightChild(new Node<>(data, node));
            }
        }

    }

    @Override
    public void remove(T data) {

        if (root == null) return;

        remove(data, root);
    }

    private void remove(T data, Node<T> node){
        if(node == null) return;

//        first we have to search for the item we want to remove
        if (data.compareTo(node.getData()) < 0){
            remove(data, node.getLeftChild());
        }else if(data.compareTo(node.getData()) > 0){
            remove(data, node.getRightChild());
        }else{

//            We have to found the item we want to remove
//            if the node is a leaf node (without left and right children)
            if(node.getLeftChild() == null && node.getRightChild() == null){

//                whether the node is a left child or right child
                Node<T> parent = node.getParentNode();

//              Scenario - 1  Leaf node scenario
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(null);
                }else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(null);
                }

//              Scenario - 2 Root node removal
                if(parent == null){
                    root = null;
                }

                node = null;
//

//                Scenario - 3 nodes with single child
            }else if(node.getLeftChild() == null && node.getRightChild() != null){

                Node<T> parent = node.getParentNode();

//                Scenario - 4 the removable node is a left child
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
                }else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getLeftChild());
                }

//              Scenario 5 --deal with the root node
                if(parent == null){
                    root = node.getLeftChild();
                }

//                have to update the right child parent
                node.getRightChild().setParentNode(parent);
                node = null;


            }
            else{

                Node<T> predecessor = getPredecessor(node.getLeftChild());

//                Swap the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

//                We have to call the delete method recursively on the predecessor
                remove(data, predecessor);
            }

        }
    }

    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

//    update the height of a given node
    private void updateHeight(Node<T> node){
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    public int height(Node<T> node){
        if(node == null) return -1;
        return node.getHeight();
    }

//    balance factor to decide the left heavy or right heavy cases
    private int getBalance(Node<T> node){
        if()
    }

    @Override
    public void traverse() {

    }
}
