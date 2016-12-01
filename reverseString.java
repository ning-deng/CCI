package chapter1;

import java.util.Arrays;

/**
 * Created by ning on 11/30/16.
 */
public class reverseString {
    public static void swapChar(char charArr[], int i, int j){
        char temp=charArr[i];
        //System.out.println(temp);
        charArr[i]=charArr[j];
        charArr[j]=temp;
    }

    public static String reverseAString(String s){
        char returnStr[]=s.toCharArray();
        int n=s.length();
        int j=0;
        int i=n-1;
        while(i>j) {
            swapChar(returnStr, i, j);
            i--;
            j++;
        }
        return String.valueOf(returnStr);
    }

    public static void main(String args[]){
        String s="abcdefg";
        String s2="abcdefgf";
        System.out.println(reverseAString(s));
        System.out.println(reverseAString(s2));
    }
}
