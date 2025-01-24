package linkedLists_02.double_LL;

public class DLL_Main {
    public static void main(String[] args) {


        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();

        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);

        dll.traverseForward();

    }
}
