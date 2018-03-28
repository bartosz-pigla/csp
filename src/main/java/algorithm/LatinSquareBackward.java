package algorithm;

import lombok.Value;
import model.LatinSquare;
import validator.LatinSquareValidator;

/**
 *
 */
@Value
public final class LatinSquareBackward {

    int problemSize;

    LatinSquare latinSquare;
    LatinSquareValidator validator;

    public void run() {
        run(0, 0);
    }

    private boolean run(int row, int column) {
        if (row == problemSize) {
            return true;
        }
        for (int i = 1; i <= problemSize; i++) {
            latinSquare.getMatrix()[row][column] = i;
            if (validator.isPartialValid(latinSquare.getMatrix(), i, row, column)) {
                if (column == problemSize - 1) {
                    if (run(++row, 0)) {
                        return true;
                    } else {
                        row--;
                    }
                } else if (run(row, ++column)) {
                    return true;
                } else {
                    column--;
                }
            } else {
                latinSquare.getMatrix()[row][column] = 0;
            }
        }
        return false;

    }

}
