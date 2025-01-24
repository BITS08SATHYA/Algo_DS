package arrays_01.exs;

public class palindrome {

    public static void main(String[] args) {
        String s = "radars";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){

        int firstIndex = 0;
        int lastIndex = s.length() - 1;

        while(firstIndex < lastIndex) {
            if (s.charAt(firstIndex) == s.charAt(lastIndex)) {
                return true;
            }
            firstIndex++;
            lastIndex--;
        }
        return false;
    }
}
