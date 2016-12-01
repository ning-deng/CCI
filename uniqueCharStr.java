package chapter1;

import java.util.HashMap;

/**
 * Created by ning on 11/28/16.
 */
public class uniqueCharStr {
    public static Boolean checkUniqueness(String s){
        HashMap<Character, Character> compHashMap=new HashMap<>();

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(compHashMap.containsKey(c)){
                return false;
            }
            else compHashMap.put(c, null);
        }
        return true;
    }

    public static void main(String[] args){
        Boolean result=checkUniqueness("abcdefg");
        System.out.println(result.toString());

        Boolean result2=checkUniqueness("abccfg");
        System.out.println(result2.toString());
    }
}
