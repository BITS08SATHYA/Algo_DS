package avl;

public class AVLApp {
    public static void main(String[] args) {

        AVLTree<Integer> avlTree = new AVLTree<Integer>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.insert(40);
        avlTree.insert(1);
        avlTree.insert(30);

        avlTree.remove(30);



    }
}
