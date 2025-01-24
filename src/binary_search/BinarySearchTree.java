package binary_search;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {


    private Node<T> root;

    @Override
    public void insert(T data) {
//        this is when we insert the first node into the BST (parent is null)
        if (root == null){
            root = new Node<>(data, null);
        }else{
//            there are items present in the bst
            insert(data, root);
        }

    }

    private void insert(T data, Node<T> node){

//        this is the case when the data is smaller than the value in the node
//        go to the left subtree

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

        if(root != null){
            remove(data, root);
        }

    }

    private void remove(T data, Node<T> node) {

        if (node == null) return;

        // first we have to search for the item we want to remove
        if (data.compareTo(node.getData()) < 0){
            remove(data, node.getLeftChild());
        }else if(data.compareTo(node.getData()) > 0){
            remove(data, node.getRightChild());
        }else{
//             We have to found the item we want to remove
//             if the node is a leaf node (without left and right children)
            if(node.getLeftChild() == null && node.getRightChild() == null){

//                whether the node is a left child or right child
                Node<T> parent = node.getParentNode();

//                the node is a left child
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(null);
//                the node is a right child
                }else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(null);
                }

//                maybe the root node is the one we want to remove
                if(parent == null){
                    root = null;
                }
//                remove the node and makes it eligible for garbage collection
                node = null;

            }
//            case 2) when we remove items with a single child
            else if(node.getLeftChild() == null && node.getRightChild() != null){
                Node<T> parent = node.getParentNode();

//                the node is a left child
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getRightChild());
//                    the node is a right child
                }else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getRightChild());
                }

//                when we deal with the root Node
                if(parent == null){
                    root = node.getRightChild();
                }

//                have to update the right child's parent
                node.getRightChild().setParentNode(parent);
                node = null;
            }
//            case 2) when we remove items with a single child
            else if(node.getLeftChild() != null && node.getRightChild() == null){
                Node<T> parent = node.getParentNode();

//                the node is a left child
                if(parent != null && parent.getLeftChild() == node){
                    parent.setLeftChild(node.getLeftChild());
//                    the node is a right child
                }else if(parent != null && parent.getRightChild() == node){
                    parent.setRightChild(node.getLeftChild());
                }

//                when we deal with the root Node
                if(parent == null){
                    root = node.getLeftChild();
                }

//                have to update the right child's parent
                node.getRightChild().setParentNode(parent);
                node = null;
            }
            else{
//                find the predecessor (max item in the left subtree
                Node<T> predecessor = getPredecessor(node.getLeftChild());

//                swap just the values
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

//                we have to call the delete method recursively on the predecessor
                remove(data, predecessor);

            }
        }


    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public void traversal() {

//        in-order traversal in o(N) linear running time -> left subtree -> root -> right st

        if(root == null){
            return;
        }

        traversal(root);


    }

    private void traversal(Node<T> node) {
        if(node.getLeftChild() != null){
            traversal(node.getLeftChild());
        }

        System.out.print(node + " - ");

        if(node.getRightChild() != null){
            traversal(node.getRightChild());
        }
    }


    //     minimum item is the left most item
    @Override
    public T getMin() {
        if(root == null) return null;
        return getMin(root);
    }

    private T getMin(Node<T> root) {
        if(root.getLeftChild() != null){
            return getMin(root.getLeftChild());
        }
        return root.getData();
    }

    @Override
    public T getMax() {
        if(root == null) return null;
        return getMax(root);
    }

    private T getMax(Node<T> node){
        if(node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
}
