package validator;

import model.Hetman;

/**
 *
 */
public final class HetmanValidator {

    private int problemSize;

    private boolean forbiddenRows[], forbiddenColumns[];
    private boolean leftDiagonal = false, rightDiagonal = false;
    private int row = 0, column = 0;

    public HetmanValidator(int problemSize) {
        this.problemSize = problemSize;
        this.forbiddenRows = new boolean[problemSize];
        this.forbiddenColumns = new boolean[problemSize];
    }

    public boolean isValid(Hetman hetman){
        return isPartialValid(hetman, 0, problemSize);
    }

    public boolean isPartialValid(Hetman hetman, int start, int end) {
        this.clear();
        for (row = start; row < end; row++) {
            boolean hetmanExists=false;
            for (column = start; column < end; column++) {
                if (hetman.getMatrix()[row][column]) {
                    hetmanExists=true;
                    if (forbiddenColumns[column] || forbiddenRows[row]) {
                        return false;
                    } else {
                        forbiddenColumns[column] = true;
                        forbiddenRows[row] = true;
                    }

                    if (row == column) {
                        if (!leftDiagonal) {
                            leftDiagonal = true;
                        } else {
                            return false;
                        }
                    } else if ((problemSize - (row + 1)) == column) {
                        if (!rightDiagonal) {
                            rightDiagonal = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            if(!hetmanExists){
                return false;
            }
        }
        return true;
    }

    private void clear() {
        row = 0;
        column = 0;
        leftDiagonal = false;
        rightDiagonal = false;
        for (int i = 0; i < problemSize; i++) {
            forbiddenRows[i] = false;
            forbiddenColumns[i] = false;
        }
    }
}
