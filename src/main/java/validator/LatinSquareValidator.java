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
                if (!isValidForColumns(latinSquare.getMatrix(), column, latinSquare.getMatrix()[row][column]) ||
                        !isValidForRows(latinSquare.getMatrix(), row, latinSquare.getMatrix()[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidForColumns(int[][] matrix, int column, int value) {
        int counter=0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][column] == value && ++counter>1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidForRows(int[][] matrix, int row, int value) {
        int counter=0;
        for (int column = 0; column < matrix.length; column++) {
            if (matrix[row][column] == value && ++counter>1) {
                return false;
            }
        }
        return true;
    }
}
