package chapter1;

/**
 * Created by ning on 12/3/16.
 */
public class checkStrRotation {
    public Boolean isSubstring(String str1, String str2){
        if(str1.contains(str2)){
            return true;
        }
        return false;
    }

    public Boolean isRotation(String str1, String str2){
        if(str1==null || str2==null){
            return false;
        }
        if(str1.length()!=str2.length()){
            return false;
        }
        return isSubstring(str1+str1,str2);
    }

    public static void main(String args[]){
        checkStrRotation csr=new checkStrRotation();
        String s1="waterbottle";
        String s2="erbottlewat";

        System.out.println(csr.isRotation(s1,s2));

        String s3="waterbottle";
        String s4="rebottlewat";

        System.out.println(csr.isRotation(s3,s4));
    }
}
