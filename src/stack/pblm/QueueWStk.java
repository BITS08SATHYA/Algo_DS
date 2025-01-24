package stack.pblm;

import queue.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueWStk {
    public static void main(String[] args) {

        Stack<Integer> enqueueStk = new Stack<>();
        Stack<Integer> dequeueStk = new Stack<>();

        List<Integer> list = new ArrayList<>();
        list.add(650);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1000);


        System.out.println(operationInsertion(list, enqueueStk,dequeueStk));

    }

    public static Integer operationInsertion(List<Integer> list,Stack<Integer> eStk, Stack<Integer> dStk){

        for(Integer i: list){
            eStk.push(i);
        }

        while(!eStk.isEmpty()){
            Integer num = eStk.pop();
            dStk.push(num);
        }

        return dStk.peek();
    }



}
