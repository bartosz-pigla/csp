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
}