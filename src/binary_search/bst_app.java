package binary_search;

public class bst_app {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(14);
        bst.insert(16);
        bst.insert(-1);

        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        bst.traversal();


    }
}
