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
        for (int value = 0; value < problemSize; value++) {
            if (!forbiddenValues[row][column][value]) {
                latinSquare.getMatrix()[row][column] = value;
                if (forward(row, column, value)) {
                    if (column == problemSize - 1) {
                        if (recursive(row + 1, 0)) {
                            return true;
                        } else {
                            revertForward(row, column, value);
                        }
                    } else {
                        if (recursive(row, column + 1)) {
                            return true;
                        } else {
                            revertForward(row, column, value);
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean forward(int row, int column, int number) {
        for (int i = row + 1; i < problemSize; i++) {
            if (notContainsAvailableValue(i, column, number)) {
                return false;
            }
        }
        for (int i = column + 1; i < problemSize; i++) {
            if (notContainsAvailableValue(row, i, number)) {
                return false;
            }
        }
        for (int i = row + 1; i < problemSize; i++) {
            forbiddenValues[i][column][number] = true;
        }
        for (int i = column + 1; i < problemSize; i++) {
            forbiddenValues[row][i][number] = true;
        }
        return true;

    }

    private void revertForward(int row, int column, int number) {
        for (int i = column + 1; i < problemSize; i++) {
            if (!columnContainsValue(row, i, number)) {
                forbiddenValues[row][i][number] = false;
            }
        }

        for (int i = row + 1; i < problemSize; i++) {
            forbiddenValues[i][column][number] = false;
        }
    }

    private boolean columnContainsValue(int row, int column, int number) {
        for (int i = 0; i < row; i++) {
            if (latinSquare.getMatrix()[i][column]==number) {
                return true;
            }
        }
        return false;
    }

    private boolean notContainsAvailableValue(int row, int column, int number) {
        for (int i = 0; i < problemSize; i++) {
            if (i != number && !forbiddenValues[row][column][i]) {
                return false;
            }
        }
        return true;
    }
}
