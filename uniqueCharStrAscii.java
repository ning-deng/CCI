package chapter1;

/**
 * Created by ning on 11/29/16.
 */
public class uniqueCharStrAscii {
    public static Boolean isUnique(String s){
        Boolean charCheck[]=new Boolean[256];
        for(int i=0;i<s.length();i++){
            int code=(int) s.charAt(i);
            if(charCheck[code]!=null) return false;
            else charCheck[code]=true;
        }
        return true;
    }

    public static Boolean isUnique2(String s){
        int charCheck[]=new int[8];
        for(int i=0;i<s.length();i++){
            int code=(int) s.charAt(i);
            int idx=code/32;
            int shift=code%32;
            int tempBit=charCheck[idx];
            if(((tempBit>>shift) & 1)==1) return false;
            else  charCheck[idx]|=(1<<shift);
        }
        return true;
    }

    public static void main(String[] args){
        Boolean result=isUnique("abcdefg");
        System.out.println(result.toString());

        Boolean result2=isUnique("abccfg");
        System.out.println(result2.toString());

        Boolean result3=isUnique2("abcdefg");
        System.out.println(result3.toString());

        Boolean result4=isUnique2("abcdcg");
        System.out.println(result4.toString());
    }
}
