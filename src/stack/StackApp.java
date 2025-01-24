package stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> names = new Stack<>();
        names.push("Adam");
        names.push("Anna");
        names.push("Kevin");
        names.push("Michael");

        while(!names.isEmpty()) {
            System.out.println(names.pop());
        }




    }
}
