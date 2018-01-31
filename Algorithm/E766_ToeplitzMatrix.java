
public class E766_ToeplitzMatrix{

    public static void main(String[] args){
        int[][] a = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] b = {{1,2},{2,2}};
        int[][] c = {{11,74,7,93},{40,11,74,7}};
        //System.out.println(1+","+a[2][3]);
        System.out.println(isToeplitzMatrix(c));
        System.out.println(isToeplitzMatrix(c));
    }
    public static boolean isToeplitzMatrix(int[][] matrix){
        if(matrix.length == 1 || matrix[0].length == 1)
            return true;
        
        int i = 0, x = 0, y = 0;
        while(i < matrix.length-1 && i < matrix[0].length - 1){
            if(matrix[i][i] != matrix[++i][i])
                return false;
        }
        for(i = 1; i < matrix.length -1; i++){
            for(x = i, y = 0; x < matrix.length - 1 && y < matrix[0].length-1; y++,x++){
                if(matrix[x][y] != matrix[x+1][y+1])
                    return false;
            }
        }
        for(i = 1; i < matrix[0].length - 1; i++){
            for(x = 0, y = i; x < matrix.length -1 && y < (matrix[0].length - 1); x++,y++){
                if(matrix[x][y] != matrix[x+1][y+1])
                    return false;
            }
        }
        return true;
    }

}
