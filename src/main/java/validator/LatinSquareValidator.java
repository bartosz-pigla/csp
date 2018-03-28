package validator;

import model.LatinSquare;

/**
 *
 */
public final class LatinSquareValidator {

    private int problemSize;

    public LatinSquareValidator(int problemSize) {
        this.problemSize = problemSize;
    }

    public boolean isValid(LatinSquare latinSquare) {
        for (int row = 0; row < problemSize; row++) {
            for (int column = 0; column < problemSize; column++) {
                if (!isValidForColumns(latinSquare.getMatrix(), column, latinSquare.getMatrix()[row][column], problemSize) ||
                        !isValidForRows(latinSquare.getMatrix(), row, latinSquare.getMatrix()[row][column], problemSize)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidForColumns(int[][] matrix, int column, int value, int end) {
        int counter = 0;
        for (int row = 0; row <= end; row++) {
            if (matrix[row][column] == value && ++counter > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidForRows(int[][] matrix, int row, int value, int end) {
        int counter = 0;
        for (int column = 0; column <= end; column++) {
            if (matrix[row][column] == value && ++counter > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isPartialValid(int[][] matrix, int value, int rowIdx, int columnIdx){
       return isValidForRows(matrix, rowIdx, value, columnIdx) &&
               isValidForColumns(matrix, columnIdx, value, rowIdx);
    }
}
