package arrays_01.exs;

import java.util.Arrays;

public class anagram {
    public static void main(String[] args) {

        char[] s1 = "restful".toCharArray();
        char[] s2 = "fluster".toCharArray();

        boolean value = solve(s1, s2);
        System.out.println(value);

    }

    public static boolean solve(char[] s1, char[] s2){


        if(s1.length != s2.length){
            return false;
        }

        Arrays.sort(s1);
        Arrays.sort(s2);

        for(int i=0;i<s1.length;i++){
            if(s1[i] == s2[i]){
                return true;
            }
        }
        return false;
    }
}
