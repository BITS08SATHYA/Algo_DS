package arrays_01.exs;

public class reverse_array {
    public static void main(String[] args) {

        int[] input = {1,2,3,4,5,6,7,8,9,10,11};

//        int[] output = solve(input);

        int[] output = solve_author(input);

        for(int i:output){
            System.out.println(i);
        }
    }

    public static int[] solve(int[] arr){

        int runtime = arr.length / 2;

        for(int i=0;i<arr.length/2;i++){
            int second = arr.length - i - 1;
            swap(arr, i, second);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] solve_author(int[] arr){

        int lowIndex = 0;
        int highIndex = arr.length - 1;

        while(lowIndex < highIndex){
            swap(arr, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }

        return arr;
    }


}
