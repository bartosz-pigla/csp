package algorithm;

import static common.ArrayUtils.clearArray;

import model.Hetman;

public final class HetmanForward {

    private int problemSize;

    private Hetman hetman;

    private boolean leftDiagonalFilled, rightDiagonalFilled;
    private boolean rowsFilled[], columnsFilled[];

    public HetmanForward(int problemSize, Hetman hetman) {
        this.problemSize = problemSize;
        this.hetman = hetman;
        rowsFilled = new boolean[problemSize];
        columnsFilled = new boolean[problemSize];
    }

    public void run(){
        clear();
        run(0);
    }

    private boolean run(int row) {
        if (row == problemSize) {
            return true;
        }

        int temp;
        for (int column = 0; column < problemSize; column++) {
            temp = tryToInsertHetmanToRow(row, column, problemSize);
            if (temp != -1) {
                column = temp;
                if (run(++row)) {
                    return true;
                }
                else{
                    hetman.getMatrix()[row][column]=false;
                    forward(row, column, false);
                }
            }
        }
        return false;
    }

    private int tryToInsertHetmanToRow(int row, int start, int end) {
        for (int column = start; column < end; column++) {
            if (!(rowsFilled[row] ||
                    columnsFilled[column] ||
                    (row == column && leftDiagonalFilled) || (problemSize - row - 1 == column)
                    && rightDiagonalFilled)) {
                hetman.getMatrix()[row][column]=true;
                forward(row, column, true);
                return column;
            }
        }
        return -1;
    }

    private void forward(int row, int column, boolean value) {
        rowsFilled[row] = value;
        columnsFilled[column] = value;
        if (row == column) {
            leftDiagonalFilled = value;
        }
        if (problemSize - row - 1 == column) {
            rightDiagonalFilled = value;
        }
    }

    private void clear(){
        clearArray(rowsFilled);
        clearArray(columnsFilled);
        leftDiagonalFilled=false;
        rightDiagonalFilled=false;
    }
}
