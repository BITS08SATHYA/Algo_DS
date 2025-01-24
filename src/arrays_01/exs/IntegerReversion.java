package arrays_01.exs;

public class IntegerReversion {
    public static void main(String[] args) {
        int i = 1234;
        System.out.println(i);
        System.out.println(reversion(i));
        System.out.println(reversion_author(i));
    }

    public static int reversion(int n){
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int lowIndex = 0;
        int highIndex = chars.length - 1;
        while(lowIndex < highIndex){
            swap(chars, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static int reversion_author(int n){
        int reversed = 0;
        int remainder = 0;
        while(n > 0){
            remainder = n % 10;
            n = n / 10;
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }
}
