package common;

/**
 *
 */
public final class ArrayUtils {

    public static void fillMatrix(boolean[][] matrix){
        for(int i=0;i<matrix.length;i++){
            matrix[i] = new boolean[matrix.length];
        }
    }

    public static void fillMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            matrix[i] = new int[matrix.length];
        }
    }

    public static void clearMatrix(boolean[][] matrix){
        for(int i = 0; i<matrix.length;i++){
            for(int j=0; j<matrix.length; j++){
                matrix[i][j] = false;
            }
        }
    }

    public static void clearArray(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=false;
        }
    }
}
