package arrays_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Arrays_1 {

    public static void main(String[] args) {



//         Time complexity - O(N) (Big O Notation)
//        Space Complexity - O(N)

        ArrayList<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(100);
//        list.add(1000);
//        list.add(10000);
//        list.add(100000);
//        list.add(1000000);
        list.add(10000000);

        for(Integer w: list){
            List<Integer> nums = new ArrayList<>();
//          Elements added Successfully sequentially
//            long x = System.nanoTime();  // Timer start value
            //  Elements added randomly Successfully

            for(int i=0;i<w;i++){
                nums.add(i);
            }
//            long y = System.nanoTime(); // Timer stop value

            long xR = System.nanoTime();  // Timer start value
            nums.add(150055, 148);
            nums.add(2497895, 1999);
            nums.add(5550000, 21);
            nums.add(7917888, 20);
            nums.add(999, 3);

            long yR = System.nanoTime(); // Timer stop value

//            System.out.println("ArrayList: ");
            System.out.println("i = "+ w + " elements" + " : Time: " + (yR-xR) / 1_000_000.0 + " milliseconds");
        }
    }
}
