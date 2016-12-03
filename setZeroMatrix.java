package chapter1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ning on 12/3/16.
 */
public class setZeroMatrix {
    public int[][] setZeroForMatrix(int arr[][]){
        if(arr==null) return null;

        HashMap<Integer,ArrayList<Integer>> coordinateMap=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    if(!coordinateMap.containsKey(i)){
                        coordinateMap.put(i,null);
                    }
                    if(!coordinateMap.containsValue(j)){
                        ArrayList<Integer> temp=new ArrayList<>();
                        if(coordinateMap.get(i)!=null){
                            temp=coordinateMap.get(i);
                        }
                        temp.add(j);
                        coordinateMap.put(i,temp);
                    }
                }
            }
        }

        for(int key: coordinateMap.keySet()){
            for(int j=0;j<arr[0].length;j++){
                arr[key][j]=0;
            }
            ArrayList<Integer> temp=coordinateMap.get(key);
            for(int k=0;k<temp.size();k++){
                for(int i=0;i<arr.length;i++){
                    arr[i][temp.get(k)]=0;
                }
            }
        }
        return arr;
    }

    public static void main(String args[]){
        setZeroMatrix szm=new setZeroMatrix();

        int testMatrix[][]={{1,2,3,4},{5,7,0,9},{0,0,1,10}};
        testMatrix=szm.setZeroForMatrix(testMatrix);
        for(int i=0;i<testMatrix.length;i++){
            for(int j=0;j<testMatrix[0].length;j++){
                System.out.print(testMatrix[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

}

