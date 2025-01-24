package stack.arrStacks;

public class Stack<T>{

    private T[] stack;
    private int count;

    public Stack(){
        stack = (T[]) new Object[1];
    }

    public void push(T newData){

//        Arrays are not dynamic data structures
//        we have to resize the underlying array if necessary
//        if there are too many items: we double the size of the arr
//        if there are too few items: then we decrease the arrays

        if(count == stack.length){
            resize(2*count);
        }

        stack[count++] = newData;

    }
//this is the bottleneck of the application O(N)
    private void resize(int newSize){
        T[] stackCopy = (T[]) new Object[newSize];

        for(int i=0;i<count;++i){
            stackCopy[i] = stack[i];
        }

        stack = stackCopy;
    }

}
