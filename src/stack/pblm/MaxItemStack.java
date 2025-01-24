package stack.pblm;

import java.util.Stack;

public class MaxItemStack {
    public static void main(String[] args) {


        Stack<Integer> s1 = new Stack<>();
        s1.push(1000);
        s1.push(28);
        s1.push(3);
        s1.push(44);
        s1.push(5);

        System.out.println(getMax(s1));
    }

    public static Integer getMax(Stack<Integer> stack) {

        Integer max = stack.peek();

        while(!stack.isEmpty()){
            Integer stackValue = stack.pop();

            if(stackValue > max){
                max = stackValue;
            }
        }

        return max;
    }
}
