package chapter1;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by ning on 12/1/16.
 */
public class compressStr {
    public static String compressString(String str){
        if(str==null){return  null;}
        if(str.isEmpty()||str.length()==1) return str;

        HashMap<Character,Integer> countMap=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(countMap.containsKey(c)){
                int tempCount=countMap.get(c);
                countMap.put(c, ++tempCount);
            }
            else{
                countMap.put(c,1);
            }
        }

        if(countMap.keySet().size()==str.length()){return str;}
        StringBuffer sb=new StringBuffer();
        for(char k: countMap.keySet()){
            sb.append(String.valueOf(k));
            sb.append(String.valueOf(countMap.get(k)));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String s="aabbccefdg";
        System.out.println(compressString(s));

        String s2="abcdefg";
        System.out.println(compressString(s2));

        String s3=" ";
        System.out.println(compressString(s3));
    }
}
