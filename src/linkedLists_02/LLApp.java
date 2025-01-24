package linkedLists_02;

import linkedLists_02.impl.LinkedList;

public class LLApp {

    public static void main(String[] args) {


//        LinkedList<String> names = new LinkedList<>();

//        names.insert("Adam");
//        names.insert("Daniel");
//        names.insert("Ana");
//
//        names.traverse();
//
//        System.out.println("-----");
//
//        names.remove("Daniel");
//        names.traverse();

//        LinkedList<Person> people = new LinkedList<>();
//        people.insert(new Person(23, "Adam"));
//        people.insert(new Person(34, "Daniel"));
//        people.insert(new Person(56, "Ana"));
//
//        Person p = new Person(34, "Daniel");
//
//        people.remove(p);
//        people.traverse();
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
        LinkedList<Integer> nums = new LinkedList<>();
        nums.insert(1);
        nums.insert(2);
        nums.insert(3);
        nums.insert(4);
//        nums.insert(5);

//        nums.insertMiddle(2,99);

//        nums.remove(4);
        nums.traverse();
        nums.traverseReversely();
        System.out.println();
        nums.traverse();
//        System.out.println(nums.getMiddleNodeUsingPointers());

    }
}
