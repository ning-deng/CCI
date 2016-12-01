package chapter1;

/**
 * Created by ning on 11/30/16.
 */
public class spaceReplacement {
    public static String spaceReplace(char[] str, int trueLength){
        int newLength=trueLength;
        for(int i=0;i<trueLength;i++){
            if(str[i]==' '){
                newLength+=2;
            }
        }
        int newStrIdx=newLength-1;
        for(int j=trueLength-1;j>=0;j--){
            if(str[j]==' '){
                str[newStrIdx]='0';
                str[--newStrIdx]='2';
                str[--newStrIdx]='%';
                newStrIdx--;
            }
            else {
                str[newStrIdx]=str[j];
                newStrIdx--;
            }
        }
        return String.valueOf(str);
    }

    public static void main(String args[]){
        char ch[]={'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        System.out.println(spaceReplace(ch,13));
    }
}
