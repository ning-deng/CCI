package chapter1;

import java.util.HashMap;

/**
 * Created by ning on 11/30/16.
 */
public class permuStrCheck {
    public static Boolean permutationCheck(String s1, String s2){
        if(s1==null && s2==null){
            return true;
        }
        if(s1==null || s2==null){
            return false;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> checkMap=new HashMap<>();
        for(int i=0;i<s1.length(); i++){
            char c=s1.charAt(i);
            if(checkMap.containsKey(c)){
                int count=checkMap.get(c);
                checkMap.put(c,++count);
            }
            else {
                checkMap.put(c,1);
            }
        }
        for(int j=0;j<s2.length();j++){
            char c=s2.charAt(j);
            if(checkMap.containsKey(c)){
                int count=checkMap.get(c);
                if(count==0){
                    return false;
                }
                else{
                    checkMap.put(c,--count);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        String s1="abcdefg";
        String s2="badcfge";
        System.out.println(permutationCheck(s1,s2));

        String s3="aabcefg";
        String s4="abccefg";
        System.out.println(permutationCheck(s3,s4));

        String s5="aabbccd";
        String s6="aabbcdd";
        System.out.println(permutationCheck(s5,s6));

    }
}
