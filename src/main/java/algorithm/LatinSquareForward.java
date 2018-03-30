package algorithm;

import static common.ArrayUtils.fillThreeDimensionArray;

import model.LatinSquare;

/**
 *
 */
public final class LatinSquareForward {

    private int problemSize;
    private LatinSquare latinSquare;

    private boolean[][][] forbiddenValues;

    public LatinSquareForward(int problemSize, LatinSquare latinSquare) {
        this.problemSize = problemSize;
        this.latinSquare = latinSquare;
        this.forbiddenValues = new boolean[problemSize][][];
        fillThreeDimensionArray(forbiddenValues);
    }

    public void run() {
        recursive(0, 0);
    }

    private boolean recursive(int row, int column) {
        if (row == problemSize) {
            return true;
        }
        for (int i = 0; i < problemSize; i++) {
            if(!forbiddenValues[row][column][i]){
                latinSquare.getMatrix()[row][column] = i;
                if (forward(row, column, i)) {
                    if (column == problemSize - 1) {
                        if (recursive(row+1, 0)) {
                            return true;
                        } else {
                            latinSquare.getMatrix()[row][column] = 0;
                            revertForward(row, column,i);
                        }
                    } else {
                        if (recursive(row, column+1)) {
                            return true;
                        } else {
                            latinSquare.getMatrix()[row][column] = 0;
                            revertForward(row, column,i);
                        }
                    }
                } else {
                    latinSquare.getMatrix()[row][column] = 0;
                }
            }
        }
        return false;
    }

    private boolean forward(int row, int column, int number) {
        for (int i = row; i < problemSize; i++) {
            if (notContainsAvailableValue(i, column)) {
                return false;
            }
        }
        for (int j = column; j < problemSize; j++) {
            if (notContainsAvailableValue(row, j)) {
                return false;
            }
        }
        for (int i = row; i < problemSize; i++) {
            forbiddenValues[i][column][number] = true;
        }
        for (int j = column; j < problemSize; j++) {
            forbiddenValues[row][j][number] = true;
        }
        return true;
    }

    private void revertForward(int row, int column, int number) {
        for (int i = row; i < problemSize; i++) {
            forbiddenValues[i][column][number] = false;
        }
        for (int j = column; j < problemSize; j++) {
            forbiddenValues[row][j][number] = false;
        }
    }

    private boolean notContainsAvailableValue(int row, int column) {
        for (int i = 0; i < problemSize; i++) {
            if (!forbiddenValues[row][column][i]) {
                return false;
            }
        }
        return true;
    }
}
