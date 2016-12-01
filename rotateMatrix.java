package chapter1;

/**
 * Created by ning on 12/1/16.
 */
public class rotateMatrix {
    public class coordinatePair{
        public int row;
        public int col;
        public coordinatePair(int i, int j){
            this.row=i;
            this.col=j;
        }
    }

    public void  arrSwap(int arr[][], coordinatePair c1, coordinatePair c2){
        int temp=arr[c1.row][c1.col];
        arr[c1.row][c1.col]=arr[c2.row][c2.col];
        arr[c2.row][c2.col]=temp;
    }

    public int[][] matrixRotate(int arr[][]){
        if(arr.length!=arr[0].length){return null;}
        int rowCount=arr.length;
        for(int i=0;i<rowCount;i++){
            for(int j=i+1;j<rowCount;j++){
                coordinatePair c1=new coordinatePair(i,j);
                coordinatePair c2=new coordinatePair(j,i);
                arrSwap(arr,c1,c2);
            }
        }
    //counter-clockwise 90 degree
        /*
        for(int i=0;i<rowCount/2;i++){
            for(int j=0; j<rowCount;j++){
                coordinatePair c1=new coordinatePair(i, j);
                coordinatePair c2=new coordinatePair(rowCount-i-1,j);
                arrSwap(arr,c1,c2);
            }
        }
        */
        //clockwise 90 degree
        for(int i=0;i<rowCount/2;i++){
            for(int j=0; j<rowCount;j++){
                coordinatePair c1=new coordinatePair(j, i);
                coordinatePair c2=new coordinatePair(j,rowCount-i-1);
                arrSwap(arr,c1,c2);
            }
        }
        return arr;
    }

    public static void main(String args[]){
        int[][] arr=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotateMatrix x=new rotateMatrix();
        arr=x.matrixRotate(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
